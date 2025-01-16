package ec.com.sofka.commands.usecases.create;

import ec.com.sofka.aggregates.auth.AuthAggregate;
import ec.com.sofka.commands.UserCommand;
import ec.com.sofka.exceptions.ConflictException;
import ec.com.sofka.gateway.IEventStore;
import ec.com.sofka.gateway.IUserRepository;
import ec.com.sofka.gateway.bus.EventBusMessage;
import ec.com.sofka.queries.responses.UserResponse;
import org.springframework.security.crypto.password.PasswordEncoder;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class CreateUserUseCase {
    private final IEventStore repository;
    private final IUserRepository userRepository;
    private final EventBusMessage eventBusMessage;
    private final PasswordEncoder passwordEncoder;

    public CreateUserUseCase(IEventStore repository, IUserRepository userRepository, EventBusMessage eventBusMessage, PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.userRepository = userRepository;
        this.eventBusMessage = eventBusMessage;
        this.passwordEncoder = passwordEncoder;
    }

    public Mono<UserResponse> execute(UserCommand userCommand) {
        return userRepository.findByEmail(userCommand.getEmail())
                .flatMap(user -> Mono.<UserResponse>error(new ConflictException("Email already exists.")))
                .switchIfEmpty(Mono.defer(() -> {
                    AuthAggregate authAggregate = new AuthAggregate();
                    authAggregate.createUser(
                            userCommand.getFirstName(),
                            userCommand.getLastName(),
                            userCommand.getEmail(),
                            passwordEncoder.encode(userCommand.getPassword()),
                            userCommand.getRole(),
                            userCommand.getRating()
                    );

                    return Flux.fromIterable(authAggregate.getUncommittedEvents())
                            .flatMap(repository::save)
                            .doOnNext(eventBusMessage::sendEvent)
                            .then(Mono.fromCallable(() -> {
                                authAggregate.markEventsAsCommitted();
                                return new UserResponse(
                                        userCommand.getFirstName(),
                                        userCommand.getLastName(),
                                        userCommand.getEmail(),
                                        userCommand.getRole(),
                                        userCommand.getRating()
                                );
                            }));
                }));
    }
}
