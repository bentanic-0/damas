package ec.com.sofka.aggregates.match.entities.move;

import ec.com.sofka.aggregates.match.entities.move.values.MoveId;
import ec.com.sofka.aggregates.match.entities.piece.values.PieceId;
import ec.com.sofka.aggregates.match.entities.piece.values.objects.Position;
import ec.com.sofka.aggregates.match.entities.player.values.PlayerId;
import ec.com.sofka.generics.shared.Entity;

public class Move extends Entity<MoveId> {
    private final PlayerId playerId;
    private final PieceId pieceId;
    private final Position startPosition;
    private final Position endPosition;
    private final boolean capture;

    public Move(MoveId id, PlayerId playerId, PieceId pieceId, Position startPosition, Position endPosition, boolean capture) {
        super(id);
        this.playerId = playerId;
        this.pieceId = pieceId;
        this.startPosition = startPosition;
        this.endPosition = endPosition;
        this.capture = capture;
    }

    public PlayerId getPlayerId() {
        return playerId;
    }

    public PieceId getPieceId() {
        return pieceId;
    }

    public Position getStartPosition() {
        return startPosition;
    }

    public Position getEndPosition() {
        return endPosition;
    }

    public boolean isCapture() {
        return capture;
    }
}
