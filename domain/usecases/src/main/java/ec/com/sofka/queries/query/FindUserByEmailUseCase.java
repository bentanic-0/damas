package ec.com.sofka.queries.query;

import ec.com.sofka.gateway.IUserRepository;
import ec.com.sofka.mapper.UserMapper;
import ec.com.sofka.queries.responses.UserResponse;
import reactor.core.publisher.Mono;

public class FindUserByEmailUseCase {
    private final IUserRepository userRepository;

    public FindUserByEmailUseCase(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Mono<UserResponse> execute(String email) {
        return userRepository.findByEmail(email)
                .map(UserMapper::mapToResponseFromDTO);
    }
}