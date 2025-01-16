package ec.com.sofka.mapper;

import ec.com.sofka.aggregates.match.entities.player.Player;
import ec.com.sofka.data.MatchEntity;
import ec.com.sofka.gateway.dto.MatchDTO;

public class MatchEntityMapper {
    public static MatchEntity toEntity(MatchDTO matchDTO) {
        return new MatchEntity(
                matchDTO.getId(),
                matchDTO.getStatus(),
                matchDTO.getPlayer1().getId(),
                matchDTO.getPlayer2().getId(),
                BoardMapper.mapToModelFromDTO(matchDTO.getBoard()),
                PieceMapper.toModelList(matchDTO.getPieces()),
                MoveMapper.toModelList(matchDTO.getMoves()),
                matchDTO.getWinnerId(),
                matchDTO.isDraw()
        );
    }

    public static MatchDTO toDTO(MatchEntity matchEntity, Player player1, Player player2) {
        return new MatchDTO(
                matchEntity.getId(),
                PlayerMapper.mapToDTOFromModel(player1, null), // Convertir Player a PlayerDTO
                PlayerMapper.mapToDTOFromModel(player2, null), // Convertir Player a PlayerDTO
                BoardMapper.mapToDTOFromModel(matchEntity.getBoard()), // Convertir Board a BoardDTO
                matchEntity.getStatus(),
                PieceMapper.toDTOList(matchEntity.getPieces()), // Convertir List<Piece> a List<PieceDTO>
                MoveMapper.toDTOList(matchEntity.getMoveHistory()), // Convertir List<Move> a List<MoveDTO>
                matchEntity.getWinnerId(),
                matchEntity.isDraw()
        );
    }
}