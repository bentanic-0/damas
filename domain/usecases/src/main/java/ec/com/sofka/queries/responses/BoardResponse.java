package ec.com.sofka.queries.responses;

import java.io.Serializable;
import java.util.Map;

public class BoardResponse implements Serializable {
    private int size;
    private Map<String, String> pieces;

    public BoardResponse(int size, Map<String, String> pieces) {
        this.size = size;
        this.pieces = pieces;
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
}
