package ec.com.sofka.commands.usecases;
/*
import ec.com.sofka.aggregates.auth.AuthAggregate;
import ec.com.sofka.commands.UserCommand;

import ec.com.sofka.gateway.IEventStore;

import ec.com.sofka.gateway.IUserRepository;
import ec.com.sofka.gateway.bus.ErrorBusMessage;
import ec.com.sofka.gateway.bus.EventBusMessage;
import ec.com.sofka.generics.interfaces.IUseCaseExecute;
import ec.com.sofka.model.ErrorMessage;
import ec.com.sofka.queries.responses.UserResponse;
import org.springframework.security.crypto.password.PasswordEncoder;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class RegisterUserUseCase implements IUseCaseExecute<UserCommand, UserResponse> {
    private final IEventStore repository;
    private final IUserRepository userRepository;
    private final ErrorBusMessage errorBusMessage;
    private final EventBusMessage eventBusMessage;
    private final PasswordEncoder passwordEncoder;

    public RegisterUserUseCase(IEventStore repository, IUserRepository userRepository, ErrorBusMessage errorBusMessage, EventBusMessage eventBusMessage, PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.userRepository = userRepository;
        this.errorBusMessage = errorBusMessage;
        this.eventBusMessage = eventBusMessage;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Mono<UserResponse> execute(UserCommand userCommand) {
        AuthAggregate authAggregate = new AuthAggregate();

        return userRepository.findByEmail(userCommand.getEmail())
                .flatMap(existingUser -> {
                    errorBusMessage.sendMsg(new ErrorMessage("Email already registered: " + userCommand.getEmail(), "Register User"));
                    return Mono.error(new ConflictException("The email is already registered."));
                })
                .switchIfEmpty(Mono.defer(() -> {
                    authAggregate.createUser(
                            userCommand.getFirstName(),
                            userCommand.getLastName(),
                            userCommand.getEmail(),
                            passwordEncoder.encode(userCommand.getPassword()),
                            userCommand.getRole()
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
                                        0 // Default rating
                                );
                            }));
                }));
    }
}
*/