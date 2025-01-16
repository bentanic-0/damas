package ec.com.sofka.aggregates.auth.entities.user.values.objects;

import ec.com.sofka.generics.interfaces.IValueObject;

import java.util.regex.Pattern;

public class Email implements IValueObject<String> {
    private static final Pattern EMAIL_PATTERN =
            Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");

    private final String value;

    private Email(final String value) {
        this.value = validate(value);
    }

    public static Email of(final String value) {
        return new Email(value);
    }

    @Override
    public String getValue() {
        return value;
    }

    private String validate(final String value) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("The email cannot be null or blank.");
        }

        if (!EMAIL_PATTERN.matcher(value).matches()) {
            throw new IllegalArgumentException("Invalid email format.");
        }

        return value;
    }
}
