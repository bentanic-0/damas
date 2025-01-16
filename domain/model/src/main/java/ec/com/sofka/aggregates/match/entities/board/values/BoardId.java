package ec.com.sofka.aggregates.match.entities.board.values;

import ec.com.sofka.generics.shared.Identity;

public class BoardId extends Identity {
    public BoardId() {
        super();
    }

    private BoardId(final String id) {
        super(id);
    }

    public static BoardId of(final String id) {
        return new BoardId(id);
    }
}
