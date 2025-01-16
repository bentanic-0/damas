package ec.com.sofka.gateway.dto;

import ec.com.sofka.utils.enums.MatchStatusEnum;

import java.util.List;

public class MatchDTO {
    private String id;
    private PlayerDTO player1;
    private PlayerDTO player2;
    private BoardDTO board;
    private MatchStatusEnum status;
    private List<PieceDTO> pieces;
    private List<MoveDTO> moves;
    private String winnerId;
    private boolean draw;

    public MatchDTO() {}

    public MatchDTO(String id, PlayerDTO player1, PlayerDTO player2, BoardDTO board, MatchStatusEnum status, List<PieceDTO> pieces, List<MoveDTO> moves, String winnerId, boolean draw) {
        this.id = id;
        this.player1 = player1;
        this.player2 = player2;
        this.board = board;
        this.status = status;
        this.pieces = pieces;
        this.moves = moves;
        this.winnerId = winnerId;
        this.draw = draw;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public PlayerDTO getPlayer1() {
        return player1;
    }

    public void setPlayer1(PlayerDTO player1) {
        this.player1 = player1;
    }

    public PlayerDTO getPlayer2() {
        return player2;
    }

    public void setPlayer2(PlayerDTO player2) {
        this.player2 = player2;
    }

    public BoardDTO getBoard() {
        return board;
    }

    public void setBoard(BoardDTO board) {
        this.board = board;
    }

    public MatchStatusEnum getStatus() {
        return status;
    }

    public void setStatus(MatchStatusEnum status) {
        this.status = status;
    }

    public List<PieceDTO> getPieces() {
        return pieces;
    }

    public void setPieces(List<PieceDTO> pieces) {
        this.pieces = pieces;
    }

    public List<MoveDTO> getMoves() {
        return moves;
    }

    public void setMoves (List<MoveDTO> moves) {
        this.moves = moves;
    }

    public String getWinnerId() {
        return winnerId;
    }

    public void setWinnerId(String winnerId) {
        this.winnerId = winnerId;
    }

    public boolean isDraw() {
        return draw;
    }

    public void setDraw(boolean draw) {
        this.draw = draw;
    }
}