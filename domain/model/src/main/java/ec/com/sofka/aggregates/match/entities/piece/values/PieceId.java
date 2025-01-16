package ec.com.sofka.aggregates.match.entities.piece.values;

import ec.com.sofka.generics.shared.Identity;

public class PieceId extends Identity {
    public PieceId() {
        super();
    }

    private PieceId(final String id) {
        super(id);
    }

    public static PieceId of(final String id) {
        return new PieceId(id);
    }
}
