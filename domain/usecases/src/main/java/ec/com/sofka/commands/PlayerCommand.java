package ec.com.sofka.commands;

import ec.com.sofka.generics.shared.Command;

public class PlayerCommand extends Command {
    private String userId;

    public PlayerCommand(String aggregateId, String userId) {
        super(aggregateId);
        this.userId = userId;
    }

    public PlayerCommand(String userId) {
        super(null);
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
