package ec.com.sofka.queries.responses;

import java.io.Serializable;

public class PieceResponse implements Serializable {
    private String color;
    private String position;
    private boolean isKing;

    public PieceResponse(String color, String position, boolean isKing) {
        this.color = color;
        this.position = position;
        this.isKing = isKing;
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
