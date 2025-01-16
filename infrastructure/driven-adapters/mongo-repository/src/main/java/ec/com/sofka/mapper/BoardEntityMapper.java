package ec.com.sofka.mapper;

import ec.com.sofka.data.BoardEntity;
import ec.com.sofka.gateway.dto.BoardDTO;
import org.springframework.stereotype.Component;

@Component
public class BoardEntityMapper {

    public static BoardEntity mapToEntity(BoardDTO boardDTO) {
        if (boardDTO == null) {
            return null;
        }

        return new BoardEntity(
                boardDTO.getId(),
                boardDTO.getSize()
        );
    }

    public static BoardDTO mapToDTO(BoardEntity boardEntity) {
        if (boardEntity == null) {
            return null;
        }

        return new BoardDTO(
                boardEntity.getId(),
                boardEntity.getSize(),
                boardEntity.getPieces()
        );
    }
}