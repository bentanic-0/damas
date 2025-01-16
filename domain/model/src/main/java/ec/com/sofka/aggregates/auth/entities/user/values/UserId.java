package ec.com.sofka.aggregates.auth.entities.user.values;

import ec.com.sofka.generics.shared.Identity;

public class UserId extends Identity {
    public UserId() {
        super();
    }

    private UserId(String id) {
        super(id);
    }

    public static UserId of(String id) {
        return new UserId(id);
    }
}
