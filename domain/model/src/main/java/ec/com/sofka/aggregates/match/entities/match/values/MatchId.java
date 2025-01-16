package ec.com.sofka.aggregates.match.entities.match.values;

import ec.com.sofka.generics.shared.Identity;

public class MatchId extends Identity {
    public MatchId() {
        super();
    }

    private MatchId(final String id) {
        super(id);
    }

    public static MatchId of(final String id) {
        return new MatchId(id);
    }
}
