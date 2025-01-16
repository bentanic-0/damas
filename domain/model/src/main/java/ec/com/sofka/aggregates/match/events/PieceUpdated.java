package ec.com.sofka.aggregates.match.events;

import ec.com.sofka.generics.domain.DomainEvent;

public class PieceUpdated extends DomainEvent {
    private final String pieceId;
    private final String color;
    private final String position;
    private final boolean isKing;

    public PieceUpdated(String pieceId, String color, String position, boolean isKing) {
        super("piece.updated");
        this.pieceId = pieceId;
        this.color = color;
        this.position = position;
        this.isKing = isKing;
    }

    public String getPieceId() {
        return pieceId;
    }

    public String getColor() {
        return color;
    }

    public String getPosition() {
        return position;
    }

    public boolean isKing() {
        return isKing;
    }
}
