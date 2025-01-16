package ec.com.sofka.gateway.dto;

import ec.com.sofka.queries.responses.UserResponse;

public class PlayerDTO {
    private String id;
    private String userId;
    private UserResponse userResponse;

    public PlayerDTO(String id, String userId, UserResponse userResponse) {
        this.id = id;
        this.userId = userId;
        this.userResponse = userResponse;
    }

    public String getId() {
        return id;
    }

    public String getUserId() {
        return userId;
    }

    public UserResponse getUserResponse() {
        return userResponse;
    }
}
