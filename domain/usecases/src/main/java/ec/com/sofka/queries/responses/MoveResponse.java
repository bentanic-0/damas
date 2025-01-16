package ec.com.sofka.queries.responses;

import java.io.Serializable;

public class MoveResponse implements Serializable {
    private String playerId;
    private String pieceId;
    private String startPosition;
    private String endPosition;
    private boolean capture;

    public MoveResponse(String playerId, String pieceId, String startPosition, String endPosition, boolean capture) {

        this.playerId = playerId;
        this.pieceId = pieceId;
        this.startPosition = startPosition;
        this.endPosition = endPosition;
        this.capture = capture;
    }


    public String getPlayerId() {
        return playerId;
    }

    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }

    public String getPieceId() {
        return pieceId;
    }

    public void setPieceId(String pieceId) {
        this.pieceId = pieceId;
    }

    public String getStartPosition() {
        return startPosition;
    }

    public void setStartPosition(String startPosition) {
        this.startPosition = startPosition;
    }

    public String getEndPosition() {
        return endPosition;
    }

    public void setEndPosition(String endPosition) {
        this.endPosition = endPosition;
    }

    public boolean isCapture() {
        return capture;
    }

    public void setCapture(boolean capture) {
        this.capture = capture;
    }
}
