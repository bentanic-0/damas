package ec.com.sofka.queries.responses;

import java.io.Serializable;

public class PlayerResponse implements Serializable {
    private UserResponse user;

    public PlayerResponse(UserResponse user) {

        this.user = user;
    }


    public UserResponse getUser() {
        return user;
    }

    public void setUser(UserResponse user) {
        this.user = user;
    }
}
