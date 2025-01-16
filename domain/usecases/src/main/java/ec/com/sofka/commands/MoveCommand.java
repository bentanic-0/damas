package ec.com.sofka.commands;

import ec.com.sofka.generics.shared.Command;

public class MoveCommand extends Command {
    private final String playerId;
    private final String pieceId;
    private final String startPosition;
    private final String endPosition;
    private final boolean capture;

    public MoveCommand(String aggregateId, String playerId, String pieceId, String startPosition, String endPosition, boolean capture) {
        super(aggregateId);
        this.playerId = playerId;
        this.pieceId = pieceId;
        this.startPosition = startPosition;
        this.endPosition = endPosition;
        this.capture = capture;
    }

    public MoveCommand(String playerId, String pieceId, String startPosition, String endPosition, boolean capture) {
        super(null);
        this.playerId = playerId;
        this.pieceId = pieceId;
        this.startPosition = startPosition;
        this.endPosition = endPosition;
        this.capture = capture;
    }

    public String getPlayerId() {
        return playerId;
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
