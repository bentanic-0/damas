package ec.com.sofka.aggregates.match.events;

import ec.com.sofka.aggregates.match.entities.board.Board;
import ec.com.sofka.aggregates.match.entities.board.values.BoardId;
import ec.com.sofka.generics.domain.DomainEvent;

public class BoardCreated extends DomainEvent {
    private final BoardId boardId;
    private final int size;
    private final Board board;

    public BoardCreated(BoardId boardId, int size, Board board) {
        super("board.created");
        this.boardId = boardId;
        this.size = size;
        this.board = board;
    }

    public BoardId getBoardId() {
        return boardId;
    }

    public int getSize() {
        return size;
    }

    public Board getBoard() {
        return board;
    }
}