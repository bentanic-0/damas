package ec.com.sofka.aggregates.auth.entities.user.values.objects;

import ec.com.sofka.generics.interfaces.IValueObject;

public class Password implements IValueObject<String> {
    private final String value;

    private Password(final String value) {
        this.value = validate(value);
    }

    public static Password of(final String value) {
        return new Password(value);
    }

    @Override
    public String getValue() {
        return value;
    }

    private String validate(final String value) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("The password cannot be null or blank.");
        }

        if (value.length() < 8) {
            throw new IllegalArgumentException("The password must have at least 8 characters.");
        }

        if (!value.matches(".*\\d.*")) {
            throw new IllegalArgumentException("The password must contain at least one number.");
        }

        if (!value.matches(".*[A-Z].*")) {
            throw new IllegalArgumentException("The password must contain at least one uppercase letter.");
        }

        return value;
    }
}
