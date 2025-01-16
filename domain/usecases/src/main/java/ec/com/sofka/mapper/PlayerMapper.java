package ec.com.sofka.mapper;

import ec.com.sofka.aggregates.match.entities.player.Player;
import ec.com.sofka.aggregates.match.entities.player.values.PlayerId;
import ec.com.sofka.aggregates.auth.entities.user.values.UserId;
import ec.com.sofka.gateway.dto.PlayerDTO;
import ec.com.sofka.queries.responses.UserResponse;
import ec.com.sofka.aggregates.auth.events.UserCreated;
import ec.com.sofka.aggregates.auth.events.UserUpdated;

public class PlayerMapper {

    public static Player mapToModelFromDTO(PlayerDTO playerDTO) {
        if (playerDTO == null) {
            return null;
        }

        return new Player(
                PlayerId.of(playerDTO.getId()),
                UserId.of(playerDTO.getUserId())
        );
    }

    public static PlayerDTO mapToDTOFromModel(Player player) {
        if (player == null) {
            return null;
        }

        return new PlayerDTO(
                player.getId().getValue(),
                player.getUserId().getValue(),
                null // O el UserResponse correspondiente si lo tienes
        );
    }

    public static UserResponse mapToResponseFromModel(Player player, UserResponse userResponse) {
        if (player == null || userResponse == null) {
            return null;
        }
        return userResponse;
    }

    public static UserResponse mapToResponseFromDTO(PlayerDTO playerDTO) {
        if (playerDTO == null) {
            return null;
        }

        return playerDTO.getUserResponse();
    }

    public static PlayerDTO mapToDTOFromEvent(UserCreated userCreated) {
        if (userCreated == null) {
            return null;
        }

        return new PlayerDTO(
                userCreated.getUserId(),
                userCreated.getUserId(),
                null
        );
    }

    public static PlayerDTO mapToDTOFromEvent(UserUpdated userUpdated) {
        if (userUpdated == null) {
            return null;
        }

        return new PlayerDTO(
                userUpdated.getUserId(),
                userUpdated.getUserId(),
                null
        );
    }
}