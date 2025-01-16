package ec.com.sofka.queries.usecases;

import ec.com.sofka.gateway.IUserRepository;
import ec.com.sofka.gateway.dto.UserDTO;
import ec.com.sofka.generics.interfaces.IUseCaseAccept;
import org.springframework.stereotype.Service;

@Service
public class UserSavedViewUseCase implements IUseCaseAccept<UserDTO> {
    private final IUserRepository userRepository;

    public UserSavedViewUseCase(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void accept(UserDTO userDTO) {
        userRepository.save(userDTO)
                .subscribe();
    }
}
