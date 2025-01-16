package ec.com.sofka.aggregates.match.entities.player;

import ec.com.sofka.aggregates.auth.entities.user.values.UserId;
import ec.com.sofka.aggregates.match.entities.player.values.PlayerId;
import ec.com.sofka.generics.shared.Entity;


public class Player extends Entity<PlayerId> {
    private UserId userId;

    public Player(PlayerId id, UserId userId) {
        super(id);
        this.userId = userId;
    }

    public UserId getUserId() {
        return userId;
    }
}
