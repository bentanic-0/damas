package ec.com.sofka.mapper;

import ec.com.sofka.aggregates.match.entities.board.Board;
import ec.com.sofka.aggregates.match.entities.board.values.BoardId;
import ec.com.sofka.aggregates.match.entities.piece.Piece;
import ec.com.sofka.aggregates.match.entities.piece.values.PieceId;
import ec.com.sofka.gateway.dto.BoardDTO;
import ec.com.sofka.gateway.dto.PieceDTO;
import ec.com.sofka.queries.responses.BoardResponse;

import java.util.Map;
import java.util.stream.Collectors;

public class BoardMapper {

    public static Board mapToModelFromDTO(BoardDTO boardDTO) {
        if (boardDTO == null) {
            return null;
        }

        Map<PieceId, Piece> pieces = boardDTO.getPieces().entrySet().stream()
                .collect(Collectors.toMap(
                        entry -> PieceId.of(entry.getKey()),
                        entry -> PieceMapper.mapToModelFromDTO(new PieceDTO(
                                entry.getKey(),
                                null,
                                entry.getValue(),
                                false
                        ))
                ));

        Board board = new Board(BoardId.of(boardDTO.getId()), boardDTO.getSize());
        pieces.forEach(board::addPiece);
        return board;
    }

    public static BoardResponse mapToResponseFromModel(Board board) {
        if (board == null) {
            return null;
        }

        Map<String, String> pieces = board.getPieces().entrySet().stream()
                .collect(Collectors.toMap(
                        entry -> entry.getKey().getValue(),
                        entry -> PieceMapper.mapToResponseFromModel(entry.getValue()).getPosition()
                ));

        return new BoardResponse(
                board.getSize(),
                pieces
        );
    }

    public static BoardDTO mapToDTOFromModel(Board board) {
        if (board == null) {
            return null;
        }

        Map<String, String> pieces = board.getPieces().entrySet().stream()
                .collect(Collectors.toMap(
                        entry -> entry.getKey().getValue(),
                        entry -> PieceMapper.mapToDTOFromModel(entry.getValue()).getPosition()
                ));

        return new BoardDTO(
                board.getId().getValue(),
                board.getSize(),
                pieces
        );
    }
}
