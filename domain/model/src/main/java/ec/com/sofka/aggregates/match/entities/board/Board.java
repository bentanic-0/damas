package ec.com.sofka.aggregates.match.entities.board;

import ec.com.sofka.aggregates.match.entities.board.values.BoardId;
import ec.com.sofka.aggregates.match.entities.piece.Piece;
import ec.com.sofka.aggregates.match.entities.piece.values.PieceId;
import ec.com.sofka.generics.shared.Entity;

import java.util.HashMap;
import java.util.Map;

public class Board extends Entity<BoardId> {
    private final Map<PieceId, Piece> pieces;
    private final int size;

    public Board(BoardId id, int size) {
        super(id);
        this.pieces = new HashMap<>();
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public Map<PieceId, Piece> getPieces() {
        return pieces;
    }

    public void addPiece(Piece piece) {
        pieces.put(piece.getId(), piece);
    }

    public Piece getPiece(PieceId pieceId) {
        return pieces.get(pieceId);
    }

    public void addPiece(PieceId pieceId, Piece piece) {
    }
}
