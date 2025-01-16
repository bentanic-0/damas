package ec.com.sofka.mapper;

import ec.com.sofka.aggregates.match.entities.move.Move;
import ec.com.sofka.aggregates.match.entities.move.values.MoveId;
import ec.com.sofka.aggregates.match.entities.player.values.PlayerId;
import ec.com.sofka.aggregates.match.entities.piece.values.PieceId;
import ec.com.sofka.aggregates.match.entities.piece.values.objects.Position;
import ec.com.sofka.aggregates.match.events.MoveCreated;
import ec.com.sofka.gateway.dto.MoveDTO;
import ec.com.sofka.queries.responses.MoveResponse;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class MoveMapper {

    public static MoveDTO mapToDTOFromModel(Move move) {
        if (move == null) {
            return null;
        }

        return new MoveDTO(
                move.getId().getValue(),
                move.getPlayerId().getValue (),
                move.getPieceId().getValue(),
                move.getStartPosition().getValue(),
                move.getEndPosition().getValue(),
                move.isCapture()
        );
    }

    public static MoveResponse mapToResponseFromModel(Move move) {
        if (move == null) {
            return null;
        }

        return new MoveResponse(
                move.getPlayerId().getValue(),
                move.getPieceId().getValue(),
                move.getStartPosition().getValue(),
                move.getEndPosition().getValue(),
                move.isCapture()
        );
    }

    public static List<MoveResponse> mapToResponseFromModelList(Collection<Move> moves) {
        return moves.stream()
                .map(MoveMapper::mapToResponseFromModel)
                .collect(Collectors.toList());
    }

    public static MoveDTO mapToDTOFromEvent(MoveCreated event) {
        if (event == null) {
            return null;
        }

        return new MoveDTO(
                event.getMoveId(),
                event.getPlayerId(),
                event.getPieceId(),
                event.getStartPosition(),
                event.getEndPosition(),
                event.isCapture()
        );
    }

    public static MoveResponse mapToResponseFromDTO(MoveDTO moveDTO) {
        if (moveDTO == null) {
            return null;
        }

        return new MoveResponse(
                moveDTO.getPlayerId(),
                moveDTO.getPieceId(),
                moveDTO.getStartPosition(),
                moveDTO.getEndPosition(),
                moveDTO.isCapture()
        );
    }

    public static Move mapToModelFromDTO(MoveDTO moveDTO) {
        if (moveDTO == null) {
            return null;
        }

        return new Move(
                MoveId.of(moveDTO.getMoveId()),
                PlayerId.of(moveDTO.getPlayerId()),
                PieceId.of(moveDTO.getPieceId()),
                Position.of(moveDTO.getStartPosition()),
                Position.of(moveDTO.getEndPosition()),
                moveDTO.isCapture()
        );
    }

    public static List<Move> toModelList(List<MoveDTO> moveDTOs) {
        return moveDTOs.stream()
                .map(MoveMapper::mapToModelFromDTO)
                .collect(Collectors.toList());
    }

    public static List<MoveDTO> toDTOList(List<Move> moves) {
        return moves.stream()
                .map(MoveMapper::mapToDTOFromModel)
                .collect(Collectors.toList());
    }
}