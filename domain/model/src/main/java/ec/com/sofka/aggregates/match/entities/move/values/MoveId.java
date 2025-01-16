package ec.com.sofka.aggregates.match.entities.move.values;


import ec.com.sofka.generics.shared.Identity;

public class MoveId extends Identity {
    public MoveId() {
        super();
    }

    private MoveId(final String id) {
        super(id);
    }

    public static MoveId of(final String id) {
        return new MoveId(id);
    }
}
