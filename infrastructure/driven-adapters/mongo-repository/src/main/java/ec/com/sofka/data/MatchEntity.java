package ec.com.sofka.data;

import ec.com.sofka.aggregates.match.entities.board.Board;
import ec.com.sofka.aggregates.match.entities.piece.Piece;
import ec.com.sofka.utils.enums.MatchStatusEnum;
import ec.com.sofka.aggregates.match.entities.move.Move;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Document(collection = "matches")
public class MatchEntity {
    @Id
    private String id;

    @Field("match_status")
    private MatchStatusEnum status;

    @Field("player1_id")
    private String player1Id;

    @Field("player2_id")
    private String player2Id;

    @Field("board")
    private Board board;

    @Field("pieces")
    private List<Piece> pieces;

    @Field("move_history")
    private List<Move> moveHistory;

    @Field("winner_id")
    private String winnerId;

    @Field("draw")
    private boolean draw;

    public MatchEntity(String id, MatchStatusEnum status, String player1Id, String player2Id, Board board, List<Piece> pieces, List<Move> moveHistory, String winnerId, boolean draw) {
        this.id = id;
        this.status = status;
        this.player1Id = player1Id;
        this.player2Id = player2Id;
        this.board = board;
        this.pieces = pieces;
        this.moveHistory = moveHistory;
        this.winnerId = winnerId;
        this.draw = draw;
    }

    public MatchEntity() {}

    public String getId() {
        return id;
    }

    public MatchStatusEnum getStatus() {
        return status;
    }

    public String getPlayer1Id() {
        return player1Id;
    }

    public String getPlayer2Id() {
        return player2Id;
    }

    public Board getBoard() {
        return board;
    }

    public List<Piece> getPieces() {
        return pieces;
    }

    public List<Move> getMoveHistory() {
        return moveHistory;
    }

    public String getWinnerId() {
        return winnerId;
    }

    public boolean isDraw() {
        return draw;
    }
}