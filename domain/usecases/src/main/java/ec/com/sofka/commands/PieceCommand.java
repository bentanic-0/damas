package ec.com.sofka.commands;

import ec.com.sofka.generics.shared.Command;

public class PieceCommand extends Command {
    private String color;
    private String position;
    private boolean isKing;

    public PieceCommand(String aggregateId, String color, String position, boolean isKing) {
        super(aggregateId);
        this.color = color;
        this.position = position;
        this.isKing = isKing;
    }

    public PieceCommand(String color, String position, boolean isKing) {
        super(null);
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
