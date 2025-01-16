package ec.com.sofka.mapper;

import ec.com.sofka.aggregates.match.entities.match.Match;
import ec.com.sofka.aggregates.match.entities.match.values.MatchId;
import ec.com.sofka.gateway.dto.MatchDTO;
import ec.com.sofka.queries.responses.MatchResponse;
import ec.com.sofka.queries.responses.UserResponse;

public class MatchMapper {

    public static Match mapToModelFromDTO(MatchDTO matchDTO) {
        if (matchDTO == null) {
            return null;
        }

        return new Match(
                MatchId.of(matchDTO.getId()),
                matchDTO.getStatus(),
                PlayerMapper.mapToModelFromDTO(matchDTO.getPlayer1()),
                PlayerMapper.mapToModelFromDTO(matchDTO.getPlayer2()),
                null, // currentPlayer, si es necesario, puedes ajustarlo
                BoardMapper.mapToModelFromDTO(matchDTO.getBoard()),
                PieceMapper.toModelList(matchDTO.getPieces()),
                MoveMapper.toModelList(matchDTO.getMoves())
        );
    }

    public static MatchDTO mapToDTOFromModel(Match match) {
        if (match == null) {
            return null;
        }

        return new MatchDTO(
                match.getId().getValue(),
                PlayerMapper.mapToDTOFromModel(match.getPlayer1()), // Convertir Player a PlayerDTO
                PlayerMapper.mapToDTOFromModel(match.getPlayer2()), // Convertir Player a PlayerDTO
                BoardMapper.mapToDTOFromModel(match.getBoard()),
                match.getStatus(),
                PieceMapper.toDTOList(match.getPieces()),
                MoveMapper.toDTOList(match.getMoves()),
                null, // winnerId, si es necesario, puedes ajustarlo
                match.isMatchOver() // draw, si es necesario, puedes ajustarlo
        );
    }

    public static MatchResponse mapToResponseFromModel(Match match, UserResponse player1User , UserResponse player2User ) {
        if (match == null || player1User  == null || player2User  == null) {
            return null;
        }

        return new MatchResponse(
                PlayerMapper.mapToResponseFromModel(match.getPlayer1(), player1User ),
                PlayerMapper.mapToResponseFromModel(match.getPlayer2(), player2User ),
                BoardMapper.mapToResponseFromModel(match.getBoard()),
                null, // Asumiendo que no tienes MatchState en Match
                MoveMapper.mapToResponseFromModelList(match.getMoves()),
                PieceMapper.mapToResponseFromModelMap(match.getPieces())
        );
    }

    public static MatchResponse mapToResponseFromDTO(MatchDTO matchDTO) {
        if (matchDTO == null) {
            return null;
        }

        return new MatchResponse(
                PlayerMapper.mapToResponseFromDTO(matchDTO.getPlayer1()),
                PlayerMapper.mapToResponseFromDTO(matchDTO.getPlayer2()),
                BoardMapper.mapToResponseFromModel(BoardMapper.mapToModelFromDTO(matchDTO.getBoard())),
                null, // Asumiendo que no tienes MatchState en MatchDTO
                null, // No hay movimientos en el DTO
                null  // No hay piezas en el DTO
        );
    }
}