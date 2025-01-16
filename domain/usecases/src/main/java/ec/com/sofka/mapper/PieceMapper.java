package ec.com.sofka.mapper;

import ec.com.sofka.aggregates.match.entities.piece.Piece;
import ec.com.sofka.aggregates.match.entities.piece.values.PieceId;
import ec.com.sofka.aggregates.match.entities.piece.values.objects.Color;
import ec.com.sofka.aggregates.match.entities.piece.values.objects.Position;
import ec.com.sofka.aggregates.match.events.PieceCreated;
import ec.com.sofka.aggregates.match.events.PieceUpdated;
import ec.com.sofka.gateway.dto.PieceDTO;
import ec.com.sofka.queries.responses.PieceResponse;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PieceMapper {

    public static Piece mapToModelFromDTO(PieceDTO pieceDTO) {
        if (pieceDTO == null) {
            return null;
        }

        return new Piece(
                PieceId.of(pieceDTO.getId()),
                Color.of(pieceDTO.getColor()),
                Position.of(pieceDTO.getPosition()),
                pieceDTO.isKing()
        );
    }

    public static PieceDTO mapToDTOFromModel(Piece piece) {
        if (piece == null) {
            return null;
        }

        return new PieceDTO(
                piece.getId().getValue(),
                piece.getColor().getValue(),
                piece.getPosition().getValue(),
                piece.isKing()
        );
    }

    public static PieceResponse mapToResponseFromModel(Piece piece) {
        if (piece == null) {
            return null;
        }

        return new PieceResponse(
                piece.getColor().getValue(),
                piece.getPosition().getValue(),
                piece.isKing()
        );
    }

    public static Map<String, String> mapToDTOFromModelMap(Map<PieceId, Piece> pieces) {
        return pieces.entrySet().stream()
                .collect(Collectors.toMap(
                        entry -> entry.getKey().getValue(),
                        entry -> entry.getValue().getPosition().getValue()
                ));
    }

    public static Map<String, String> mapToResponseFromModelMap(Map<PieceId, Piece> pieces) {
        return pieces.entrySet().stream()
                .collect(Collectors.toMap(
                        entry -> entry.getKey().getValue(),
                        entry -> entry.getValue().getPosition().getValue()
                ));
    }

    public static PieceDTO mapToDTOFromEvent(PieceCreated event) {
        if (event == null) {
            return null;
        }

        return new PieceDTO(
                event.getPieceId(),
                event.getColor(),
                event.getPosition(),
                event.isKing()
        );
    }

    public static PieceResponse mapToResponseFromDTO(PieceDTO pieceDTO) {
        if (pieceDTO == null) {
            return null;
        }

        return new PieceResponse(
                pieceDTO.getColor(),
                pieceDTO.getPosition(),
                pieceDTO.isKing()
        );
    }

    public static PieceDTO mapToDTOFromUpdatedEvent(PieceUpdated event) {
        if (event == null) {
            return null;
        }

        return new PieceDTO(
                event.getPieceId(),
                event.getColor(),
                event.getPosition(),
                event.isKing()
        );
    }

    public static List<Piece> toModelList(List<PieceDTO> pieceDTOs) {
        return pieceDTOs.stream()
                .map(PieceMapper::mapToModelFromDTO)
                .collect(Collectors.toList());
    }

    public static List<PieceDTO> toDTOList(List<Piece> pieces) {
        return pieces.stream()
                .map(PieceMapper::mapToDTOFromModel)
                .collect(Collectors.toList());
    }
}