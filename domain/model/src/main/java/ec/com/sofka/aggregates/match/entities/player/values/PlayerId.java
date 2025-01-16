package ec.com.sofka.aggregates.match.entities.player.values;

import ec.com.sofka.generics.shared.Identity;

public class PlayerId extends Identity {
    public PlayerId() {
        super();
    }

    private PlayerId(String id) {
        super(id);
    }

    public static PlayerId of(String id) {
        return new PlayerId(id);
    }
}
