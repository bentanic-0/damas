package ec.com.sofka.queries.responses;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class MatchResponse implements Serializable {
    private PlayerResponse player1;
    private PlayerResponse player2;
    private BoardResponse board;
    private MatchStateResponse matchState;
    private List<MoveResponse> moves;
    private Map<String, PieceResponse> pieces;

    public MatchResponse(PlayerResponse player1, PlayerResponse player2, BoardResponse board, MatchStateResponse matchState, List<MoveResponse> moves, Map<String, PieceResponse> pieces) {
        this.player1 = player1;
        this.player2 = player2;
        this.board = board;
        this.matchState = matchState;
        this.moves = moves;
        this.pieces = pieces;
    }

    public PlayerResponse getPlayer1() {
        return player1;
    }

    public void setPlayer1(PlayerResponse player1) {
        this.player1 = player1;
    }

    public PlayerResponse getPlayer2() {
        return player2;
    }

    public void setPlayer2(PlayerResponse player2) {
        this.player2 = player2;
    }

    public BoardResponse getBoard() {
        return board;
    }

    public void setBoard(BoardResponse board) {
        this.board = board;
    }

    public MatchStateResponse getMatchState() {
        return matchState;
    }

    public void setMatchState(MatchStateResponse matchState) {
        this.matchState = matchState;
    }

    public List<MoveResponse> getMoves() {
        return moves;
    }

    public void setMoves(List<MoveResponse> moves) {
        this.moves = moves;
    }

    public Map<String, PieceResponse> getPieces() {
        return pieces;
    }

    public void setPieces(Map<String, PieceResponse> pieces) {
        this.pieces = pieces;
    }
}
