package ec.com.sofka.aggregates.match.events;

import ec.com.sofka.generics.domain.DomainEvent;

import java.util.Map;

public class BoardUpdated extends DomainEvent {
    private final String boardId;
    private final String matchId;
    private final int size;
    private final Map<String, String> pieces;

    public BoardUpdated(String boardId, String matchId, int size, Map<String, String> pieces) {
        super("board.updated");
        this.boardId = boardId;
        this.matchId = matchId;
        this.size = size;
        this.pieces = pieces;
    }

    public String getBoardId() {
        return boardId;
    }

    public String getMatchId() {
        return matchId;
    }

    public int getSize() {
        return size;
    }

    public Map<String, String> getPieces() {
        return pieces;
    }
}
