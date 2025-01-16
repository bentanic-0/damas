package ec.com.sofka.aggregates.match.events;

import ec.com.sofka.aggregates.match.entities.board.Board;
import ec.com.sofka.aggregates.match.entities.player.Player;
import ec.com.sofka.generics.domain.DomainEvent;


import ec.com.sofka.aggregates.match.entities.match.Match;


public class MatchCreated extends DomainEvent {
    private final String matchId;
    private final Player player1;
    private final Player player2;
    private final Board board;
    private final Match match;

    public MatchCreated(String matchId, Player player1, Player player2, Board board, Match match) {
        super("match.created");
        this.matchId = matchId;
        this.player1 = player1;
        this.player2 = player2;
        this.board = board;
        this.match = match;
    }

    public String getMatchId() {
        return matchId;
    }

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public Board getBoard() {
        return board;
    }

    public Match getMatchState() {
        return match;
    }
}
