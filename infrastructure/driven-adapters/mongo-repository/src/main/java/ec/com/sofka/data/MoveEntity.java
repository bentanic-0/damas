package ec.com.sofka.data;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "moves")
public class MoveEntity {

    @Id
    private String id;

    @Field(name = "playerId")
    private String playerId;

    @Field(name = "pieceId")
    private String pieceId;

    @Field(name = "startPosition")
    private String startPosition;

    @Field(name = "endPosition")
    private String endPosition;

    @Field(name = "capture")
    private boolean capture;

    @Field(name = "matchId")
    private String matchId;

    public MoveEntity() {
    }

    public MoveEntity(String id, String playerId, String pieceId, String startPosition, String endPosition, boolean capture) {
        this.id = id;
        this.playerId = playerId;
        this.pieceId = pieceId;
        this.startPosition = startPosition;
        this.endPosition = endPosition;
        this.capture = capture;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getMatchId() {
        return matchId;
    }

    public void setMatchId(String matchId) {
        this.matchId = matchId;
    }
}