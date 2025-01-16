package ec.com.sofka.aggregates.match.entities.match;

import ec.com.sofka.generics.shared.Entity;
import ec.com.sofka.aggregates.match.entities.match.values.MatchId;
import ec.com.sofka.utils.enums.MatchStatusEnum;
import ec.com.sofka.aggregates.match.entities.player.values.PlayerId;
import ec.com.sofka.aggregates.match.entities.board.Board;
import ec.com.sofka.aggregates.match.entities.piece.Piece;
import ec.com.sofka.aggregates.match.entities.move.Move;

import java.util.List;

public class Match extends Entity<MatchId> {
    private MatchStatusEnum status;
    private PlayerId player1;
    private PlayerId player2;
    private PlayerId currentPlayer;
    private PlayerId winner;
    private Board board;
    private List<Piece> pieces;
    private List<Move> moves;

    public Match(MatchId id, MatchStatusEnum status, PlayerId player1, PlayerId player2, PlayerId currentPlayer, Board board, List<Piece> pieces, List<Move> moves) {
        super(id);
        this.status = status;
        this.player1 = player1;
        this.player2 = player2;
        this.currentPlayer = currentPlayer;
        this.winner = null; // Inicialmente no hay ganador
        this.board = board;
        this.pieces = pieces;
        this.moves = moves;
    }

    // Getters y Setters
    public MatchStatusEnum getStatus() {
        return status;
    }

    public void setStatus(MatchStatusEnum status) {
        this.status = status;
    }

    public PlayerId getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(PlayerId currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public PlayerId getWinner() {
        return winner;
    }

    public void setWinner(PlayerId winner) {
        this.winner = winner;
    }

    public boolean isMatchOver() {
        return status == MatchStatusEnum.FINISHED || status == MatchStatusEnum.DRAW;
    }

    public PlayerId getPlayer1() {
        return player1;
    }

    public PlayerId getPlayer2() {
        return player2;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public List<Piece> getPieces() {
        return pieces;
    }

    public void setPieces(List<Piece> pieces) {
        this.pieces = pieces;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }
}