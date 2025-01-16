package ec.com.sofka.commands;

import ec.com.sofka.generics.shared.Command;

import java.util.Map;

public class BoardCommand extends Command {
    private int size;
    private Map<String, String> pieces; // Key: PieceId, Value: Position

    public BoardCommand(String aggregateId, int size, Map<String, String> pieces) {
        super(aggregateId);
        this.size = size;
        this.pieces = pieces;
    }

    public BoardCommand(int size, Map<String, String> pieces) {
        super(null);
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
