package ec.com.sofka.mapper;

import ec.com.sofka.data.UserEntity;
import ec.com.sofka.gateway.dto.UserDTO;
import org.springframework.stereotype.Component;

@Component
public class UserEntityMapper {

    public static UserEntity mapToEntity(UserDTO userDTO) {
        if (userDTO == null) {
            return null;
        }

        return new UserEntity(
                userDTO.getId(),
                userDTO.getEmail(),
                userDTO.getFirstName(),
                userDTO.getLastName(),
                userDTO.getPassword(),
                userDTO.getRole(),
                userDTO.getRating()
        );
    }

    public static UserDTO mapToDTO(UserEntity userEntity) {
        if (userEntity == null) {
            return null;
        }

        return new UserDTO(
                userEntity.getId(),
                userEntity.getEmail(),
                userEntity.getFirstName(),
                userEntity.getLastName(),
                userEntity.getPassword(),
                userEntity.getRole(),
                userEntity.getRating()
        );
    }
}