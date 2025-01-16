package ec.com.sofka.gateway.dto;

public class PieceDTO {
    private String id;
    private String color;
    private String position;
    private boolean isKing;

    public PieceDTO() {}

    public PieceDTO(String id, String color, String position, boolean isKing) {
        this.id = id;
        this.color = color;
        this.position = position;
        this.isKing = isKing;
    }

    public PieceDTO(String color, String position, boolean isKing) {
        this.color = color;
        this.position = position;
        this.isKing = isKing;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public boolean isKing() {
        return isKing;
    }

    public void setKing(boolean king) {
        isKing = king;
    }
}
