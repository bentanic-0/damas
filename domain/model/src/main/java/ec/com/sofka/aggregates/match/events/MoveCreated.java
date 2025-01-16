package ec.com.sofka.aggregates.match.events;

import ec.com.sofka.generics.domain.DomainEvent;

public class MoveCreated extends DomainEvent {
    private final String moveId;
    private final String pieceId;
    private final String startPosition;
    private final String endPosition;
    private final boolean capture;
    private final String playerId;

    public MoveCreated(String moveId, String pieceId, String startPosition, String endPosition, boolean capture, String playerId) {
        super("move.created");
        this.moveId = moveId;
        this.pieceId = pieceId;
        this.startPosition = startPosition;
        this.endPosition = endPosition;
        this.capture = capture;
        this.playerId = playerId;
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

    public String getPlayerId() {
        return playerId;
    }


}
