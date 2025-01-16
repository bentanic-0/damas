package ec.com.sofka.gateway.dto;

import java.util.Map;

public class BoardDTO {
    private String id;
    private int size;
    private Map<String, String> pieces;

    public BoardDTO() {}

    public BoardDTO(String id, int size, Map<String, String> pieces) {
        this.id = id;
        this.size = size;
        this.pieces = pieces;
    }

    public BoardDTO(int size, Map<String, String> pieces) {
        this.size = size;
        this.pieces = pieces;
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
}
