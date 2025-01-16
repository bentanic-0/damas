package ec.com.sofka.aggregates.match;

import ec.com.sofka.aggregates.match.entities.board.Board;
import ec.com.sofka.aggregates.match.entities.match.Match;
import ec.com.sofka.aggregates.match.entities.move.Move;
import ec.com.sofka.aggregates.match.entities.piece.Piece;
import ec.com.sofka.aggregates.match.entities.player.Player;
import ec.com.sofka.aggregates.match.events.*;
import ec.com.sofka.aggregates.match.handler.MatchHandler;
import ec.com.sofka.aggregates.match.values.MatchAggregateId;
import ec.com.sofka.generics.domain.DomainEvent;
import ec.com.sofka.generics.shared.AggregateRoot;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public class MatchAggregate extends AggregateRoot<MatchAggregateId> {
    private Player player;
    private Board board;
    private Match match;
    private Piece piece;
    private Move move;

    public MatchAggregate() {
        super(new MatchAggregateId());
        setSubscription(new MatchHandler(this));
    }

    public MatchAggregate(final String id) {
        super(MatchAggregateId.of(id));
        setSubscription(new MatchHandler(this));
    }

    public void createMatch(Player player1, Player player2, Board board, Match match) {
        addEvent(new MatchCreated(getId().getValue(), player1, player2, board, match)).apply();
    }

    public void createMove(String moveId, String playerId, String pieceId, String startPosition, String endPosition, boolean capture) {
        addEvent(new MoveCreated(
                moveId,
                pieceId,
                startPosition,
                endPosition,
                capture,
                playerId
        )).apply();
    }

    public void createPiece(String pieceId, String color, String position, boolean isKing) {
        addEvent(new PieceCreated(
                pieceId,
                color,
                position,
                isKing
        )).apply();
    }






    public static MatchAggregate from(final String id, List<DomainEvent> events) {
        MatchAggregate matchAggregate = new MatchAggregate(id);
        events.forEach(event -> matchAggregate.addEvent(event).apply());
        matchAggregate.markEventsAsCommitted();
        return matchAggregate;
    }

    // Getters y Setters
    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Match getMatch() {
        return match;
    }

    public void setMatch(Match match) {
        this.match = match;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public Move getMove() {
        return move;
    }

    public void setMove(Move move) {
        this.move = move;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }


}