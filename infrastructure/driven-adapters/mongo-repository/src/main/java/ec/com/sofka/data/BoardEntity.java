package ec.com.sofka.data;

import ec.com.sofka.aggregates.match.entities.board.values.BoardId;
import ec.com.sofka.aggregates.match.entities.piece.Piece;
import ec.com.sofka.aggregates.match.entities.piece.values.PieceId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.HashMap;
import java.util.Map;

@Document(collection = "boards")
public class BoardEntity {

    @Id
    private String id;

    @Field(name = "size")
    private int size;

    @Field(name = "pieces")
    private Map<String, String> pieces;

    @Field(name = "matchId")
    private String matchId;

    public BoardEntity() {
        this.pieces = new HashMap<>();
    }

    public BoardEntity(String id, int size) {
        this.id = id;
        this.size = size;
        this.pieces = new HashMap<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Map<String, String> getPieces() {
        return pieces;
    }

    public void setPieces(Map<String, String> pieces) {
        this.pieces = pieces;
    }

    public String getMatchId() {
        return matchId;
    }

    public void setMatchId(String matchId) {
        this.matchId = matchId;
    }

}