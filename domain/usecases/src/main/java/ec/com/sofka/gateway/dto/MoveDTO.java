package ec.com.sofka.gateway.dto;

public class MoveDTO {
    private String moveId;
    private String playerId;
    private String pieceId;
    private String startPosition;
    private String endPosition;
    private boolean capture;

    public MoveDTO() {
    }

    public MoveDTO(String moveId, String playerId, String pieceId, String startPosition, String endPosition, boolean capture) {
        this.moveId = moveId;
        this.playerId = playerId;
        this.pieceId = pieceId;
        this.startPosition = startPosition;
        this.endPosition = endPosition;
        this.capture = capture;
    }

    public MoveDTO(String playerId, String pieceId, String startPosition, String endPosition, boolean capture) {
        this.playerId = playerId;
        this.pieceId = pieceId;
        this.startPosition = startPosition;
        this.endPosition = endPosition;
        this.capture = capture;
    }

    public String getMoveId() {
        return moveId;
    }

    public void setMoveId(String moveId) {
        this.moveId = moveId;
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
