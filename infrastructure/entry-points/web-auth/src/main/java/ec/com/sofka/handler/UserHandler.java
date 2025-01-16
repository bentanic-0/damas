package ec.com.sofka.handler;

import ec.com.sofka.commands.UserCommand;
import ec.com.sofka.commands.usecases.create.CreateUserUseCase;
import ec.com.sofka.data.UserRequestDTO;
import ec.com.sofka.data.UserResponseDTO;
import ec.com.sofka.mapper.UserModelMapper;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class UserHandler {
    private final CreateUserUseCase createUserUseCase;

    public UserHandler(CreateUserUseCase createUserUseCase) {
        this.createUserUseCase = createUserUseCase;
    }

    public Mono<UserResponseDTO> save(UserRequestDTO userRequestDTO) {
        UserCommand userCommand = UserModelMapper.mapToRequest(userRequestDTO);
        return createUserUseCase.execute(userCommand)
                .map(UserModelMapper::mapToDTO);
    }
}
