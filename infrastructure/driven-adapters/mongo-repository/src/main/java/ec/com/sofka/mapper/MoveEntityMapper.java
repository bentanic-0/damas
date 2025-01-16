package ec.com.sofka.mapper;

import ec.com.sofka.data.MoveEntity;
import ec.com.sofka.gateway.dto.MoveDTO;
import org.springframework.stereotype.Component;

@Component
public class MoveEntityMapper {

    public static MoveEntity mapToEntity(MoveDTO moveDTO) {
        if (moveDTO == null) {
            return null;
        }

        return new MoveEntity(
                moveDTO.getMoveId(),
                moveDTO.getPlayerId(),
                moveDTO.getPieceId(),
                moveDTO.getStartPosition(),
                moveDTO.getEndPosition(),
                moveDTO.isCapture()
        );
    }

    public static MoveDTO mapToDTO(MoveEntity moveEntity) {
        if (moveEntity == null) {
            return null;
        }

        return new MoveDTO(
                moveEntity.getId(),
                moveEntity.getPlayerId(),
                moveEntity.getPieceId(),
                moveEntity.getStartPosition(),
                moveEntity.getEndPosition(),
                moveEntity.isCapture()
        );
    }
}