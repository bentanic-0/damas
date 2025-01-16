package ec.com.sofka.aggregates.match.entities.piece.values.objects;

import ec.com.sofka.generics.interfaces.IValueObject;

public class Color implements IValueObject<String> {
    private final String value;

    private Color(final String value) {
        this.value = validate(value);
    }

    public static Color of(final String value) {
        return new Color(value);
    }

    @Override
    public String getValue() {
        return value;
    }

    private String validate(final String value) {
        if (value == null || (!value.equals("WHITE") && !value.equals("BLACK"))) {
            throw new IllegalArgumentException("Invalid color. Must be 'WHITE' or 'BLACK'.");
        }
        return value;
    }
}
