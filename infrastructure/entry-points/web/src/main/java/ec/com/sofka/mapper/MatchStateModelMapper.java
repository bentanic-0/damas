package ec.com.sofka.mapper;
/*
import ec.com.sofka.data.MatchStateRequestDTO;
import ec.com.sofka.data.MatchStateResponseDTO;
import ec.com.sofka.commands.MatchStateCommand;
import ec.com.sofka.queries.responses.MatchStateResponse;
import ec.com.sofka.utils.enums.MatchStatusEnum;

public class MatchStateModelMapper {

    public static MatchStateCommand mapToRequest(MatchStateRequestDTO matchState) {
        if (matchState == null) {
            return null;
        }

        return new MatchStateCommand(
                matchState.getStatus().equals(MatchStatusEnum.ACTIVE.name()) ? MatchStatusEnum.ACTIVE : MatchStatusEnum.INACTIVE,
                matchState.getCurrentPlayerId(),
                matchState.getWinnerId()
        );
    }

    public static MatchStateResponseDTO mapToDTO(MatchStateResponse matchState) {
        if (matchState == null) {
            return null;
        }

        return new MatchStateResponseDTO(
                matchState.getStatus().name(),
                matchState.getCurrentPlayerId(),
                matchState.getWinnerId()
        );
    }
}

 */