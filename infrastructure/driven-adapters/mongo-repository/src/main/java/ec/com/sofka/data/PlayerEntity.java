package ec.com.sofka.data;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "players")
public class PlayerEntity {

    @Id
    private String id;

    @Field(name = "userId")
    private String userId;

    @Field(name = "matchId")
    private String matchId;

    public PlayerEntity() {
    }

    public PlayerEntity(String id, String userId) {
        this.id = id;
        this.userId = userId;
    }

    public String getId() {
    return id;
}

public void setId(String id) {
    this.id = id;
}

public String getUserId() {
    return userId;
}

public void setUserId(String userId) {
    this.userId = userId;
}

public String getMatchId() {
    return matchId;}

    public void setMatchId(String matchId) {
        this.matchId = matchId;
    }
}