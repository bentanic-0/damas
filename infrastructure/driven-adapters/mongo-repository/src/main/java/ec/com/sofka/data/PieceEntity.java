package ec.com.sofka.data;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "pieces")
public class PieceEntity {

    @Id
    private String id;

    @Field(name = "color")
    private String color;

    @Field(name = "position")
    private String position;

    @Field(name = "isKing")
    private boolean isKing;

    @Field(name = "matchId")
    private String matchId;

    @Field(name = "playerId")
    private String playerId;

    public PieceEntity() {
    }

    public PieceEntity(String id, String color, String position, boolean isKing) {
        this.id = id;
        this.color = color;
        this.position = position;
        this.isKing = isKing;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public boolean isKing() {
        return isKing;
    }

    public void setKing(boolean isKing) {
        this.isKing = isKing;
    }

    public String getMatchId() {
        return matchId;
    }

    public void setMatchId(String matchId) {
        this.matchId = matchId;
    }

    public String getPlayerId() {
        return playerId;
    }

    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }
}