package ec.com.sofka.aggregates.match.entities.piece.values.objects;

import ec.com.sofka.generics.interfaces.IValueObject;

public class Position implements IValueObject<String> {
    private final String value;

    private Position(final String value) {
        this.value = validate(value);
    }

    public static Position of(final String value) {
        return new Position(value);
    }

    @Override
    public String getValue() {
        return value;
    }

    private String validate(final String value) {
        if (value == null || !value.matches("^\\d,\\d$")) {
            throw new IllegalArgumentException("Invalid position format. Must be in 'row,column' format.");
        }
        return value;
    }
}
