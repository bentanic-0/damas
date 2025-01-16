package ec.com.sofka.aggregates.match.values;

import ec.com.sofka.generics.shared.Identity;

public class MatchAggregateId extends Identity {
    public MatchAggregateId() {
        super();
    }

    private MatchAggregateId(final String id) {
        super(id);
    }

    public static MatchAggregateId of(final String id) {
        return new MatchAggregateId(id);
    }
}
