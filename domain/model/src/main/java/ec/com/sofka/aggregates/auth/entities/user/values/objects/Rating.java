package ec.com.sofka.aggregates.auth.entities.user.values.objects;

import ec.com.sofka.generics.interfaces.IValueObject;

public class Rating implements IValueObject<Integer> {
    private final Integer value;

    private Rating(final Integer value) {
        this.value = validate(value);
    }

    public static Rating of(final Integer value) {
        return new Rating(value);
    }

    @Override
    public Integer getValue() {
        return value;
    }

    private Integer validate(final Integer value) {
        if (value == null) {
            throw new IllegalArgumentException("Rating cannot be null.");
        }

        if (value < 0 || value > 3000) {
            throw new IllegalArgumentException("Rating must be between 0 and 3000.");
        }

        return value;
    }
}
