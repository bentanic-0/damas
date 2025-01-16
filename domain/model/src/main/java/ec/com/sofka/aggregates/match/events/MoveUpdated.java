package ec.com.sofka.aggregates.match.events;

import ec.com.sofka.generics.domain.DomainEvent;

public class MoveUpdated extends DomainEvent {
    private final String moveId;
    private final String pieceId;
    private final String startPosition;
    private final String endPosition;
    private final boolean capture;

    public MoveUpdated(String moveId, String pieceId, String startPosition, String endPosition, boolean capture) {
        super("move.updated");
        this.moveId = moveId;
        this.pieceId = pieceId;
        this.startPosition = startPosition;
        this.endPosition = endPosition;
        this.capture = capture;
    }

    public String getMoveId() {
        return moveId;
    }

    public String getPieceId() {
        return pieceId;
    }

    public String getStartPosition() {
        return startPosition;
    }

    public String getEndPosition() {
        return endPosition;
    }

    public boolean isCapture() {
        return capture;
    }
}
