package ec.com.sofka.mapper;
/*
import ec.com.sofka.data.PlayerRequestDTO;
import ec.com.sofka.data.PlayerResponseDTO;
import ec.com.sofka.commands.PlayerCommand;
import ec.com.sofka.queries.responses.PlayerResponse;
import ec.com.sofka.utils.enums.StatusEnum;

public class PlayerModelMapper {

    public static PlayerCommand mapToRequest(PlayerRequestDTO player) {
        if (player == null) {
            return null;
        }

        return new PlayerCommand(
                player.getUserId(),
                player.getStatus().equals(StatusEnum.ACTIVE.name()) ? StatusEnum.ACTIVE : StatusEnum.INACTIVE
        );
    }

    public static PlayerResponseDTO mapToDTO(PlayerResponse player) {
        if (player == null) {
            return null;
        }

        return new PlayerResponseDTO(
                player.getUserId(),
                player.getStatus().name()
        );
    }
}

 */