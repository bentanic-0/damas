package ec.com.sofka.aggregates.match.entities.piece;


import ec.com.sofka.generics.shared.Entity;
import ec.com.sofka.aggregates.match.entities.piece.values.PieceId;
import ec.com.sofka.aggregates.match.entities.piece.values.objects.Color;
import ec.com.sofka.aggregates.match.entities.piece.values.objects.Position;

public class Piece extends Entity<PieceId> {
    private final Color color;
    private Position position;
    private boolean isKing;

    public Piece(PieceId id, Color color, Position position, boolean isKing) {
        super(id);
        this.color = color;
        this.position = position;
        this.isKing = isKing;
    }

    public Color getColor() {
        return color;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public boolean isKing() {
        return isKing;
    }

    public void promoteToKing() {
        this.isKing = true;
    }
}
