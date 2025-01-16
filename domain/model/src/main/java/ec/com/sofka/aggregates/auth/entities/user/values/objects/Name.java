package ec.com.sofka.aggregates.auth.entities.user.values.objects;

import ec.com.sofka.generics.interfaces.IValueObject;

public class Name implements IValueObject<String> {
    private final String value;

    private Name(final String value) {
        this.value = validate(value);
    }

    public static Name of(final String value) {
        return new Name(value);
    }

    @Override
    public String getValue() {
        return value;
    }

    private String validate(final String value) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("The name cannot be null or blank.");
        }

        if (value.length() < 3) {
            throw new IllegalArgumentException("The name must have at least 3 characters.");
        }

        return value;
    }
}
