package ec.com.sofka.mapper;

import ec.com.sofka.data.PieceEntity;
import ec.com.sofka.gateway.dto.PieceDTO;
import org.springframework.stereotype.Component;

@Component
public class PieceEntityMapper {

    public static PieceEntity mapToEntity(PieceDTO pieceDTO) {
        if (pieceDTO == null) {
            return null;
        }

        return new PieceEntity(
                pieceDTO.getId(),
                pieceDTO.getColor(),
                pieceDTO.getPosition(),
                pieceDTO.isKing()
        );
    }

    public static PieceDTO mapToDTO(PieceEntity pieceEntity) {
        if (pieceEntity == null) {
            return null;
        }

        return new PieceDTO(
                pieceEntity.getId(),
                pieceEntity.getColor(),
                pieceEntity.getPosition(),
                pieceEntity.isKing()
        );
    }
}