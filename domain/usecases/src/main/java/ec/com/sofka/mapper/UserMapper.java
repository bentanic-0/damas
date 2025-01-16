package ec.com.sofka.mapper;

import ec.com.sofka.aggregates.auth.entities.user.User;
import ec.com.sofka.aggregates.auth.entities.user.values.UserId;
import ec.com.sofka.aggregates.auth.entities.user.values.objects.Email;
import ec.com.sofka.aggregates.auth.entities.user.values.objects.Name;
import ec.com.sofka.aggregates.auth.entities.user.values.objects.Password;
import ec.com.sofka.aggregates.auth.entities.user.values.objects.Rating;
import ec.com.sofka.gateway.dto.UserDTO;

import ec.com.sofka.aggregates.auth.events.UserCreated;
import ec.com.sofka.aggregates.auth.events.UserUpdated;
import ec.com.sofka.queries.responses.UserResponse;
import ec.com.sofka.utils.enums.RoleEnum;

public class UserMapper {

    public static User mapToModelFromDTO(UserDTO userDTO) {
        if (userDTO == null) {
            return null;
        }

        return new User(
                UserId.of(userDTO.getId()),
                Name.of(userDTO.getFirstName()),
                Name.of(userDTO.getLastName()),
                Email.of(userDTO.getEmail()),
                Password.of(userDTO.getPassword()),
                userDTO.getRole(),
                Rating.of(userDTO.getRating())
        );
    }

    public static UserDTO mapToDTOFromModel(User user) {
        if (user == null) {
            return null;
        }

        return new UserDTO(
                user.getId().getValue(),
                user.getFirstName().getValue(),
                user.getLastName().getValue(),
                user.getEmail().getValue(),
                user.getPassword().getValue(),
                user.getRole(),
                user.getRating().getValue()
        );
    }

    public static UserDTO mapToDTOFromCreatedEvent(UserCreated userCreated) {
        if (userCreated == null) {
            return null;
        }

        return new UserDTO(
                userCreated.getUserId(),
                userCreated.getFirstName(),
                userCreated.getLastName(),
                userCreated.getEmail(),
                userCreated.getPassword(),
                userCreated.getRole(),
                userCreated.getRating()
        );
    }

    public static UserDTO maptoDTOFromUpdatedEvent(UserUpdated userUpdated) {
        if (userUpdated == null) {
            return null;
        }

        return new UserDTO(
                userUpdated.getUserId(),
                userUpdated.getFirstName(),
                userUpdated.getLastName(),
                userUpdated.getEmail(),
                userUpdated.getPassword(),
                userUpdated.getRole(),
                userUpdated.getRating()
        );
    }

    public static UserResponse mapToResponseFromModel(User user) {
        if (user == null) {
            return null;
        }

        return new UserResponse(
                user.getFirstName().getValue(),
                user.getLastName().getValue(),
                user.getEmail().getValue(),
                user.getRole(),
                user.getRating().getValue()
        );
    }

    public static UserResponse mapToResponseFromDTO(UserDTO userDTO) {
        if (userDTO == null) {
            return null;
        }

        return new UserResponse(
                userDTO.getFirstName(),
                userDTO.getLastName(),
                userDTO.getEmail(),
                userDTO.getRole(),
                userDTO.getRating()
        );
    }


}