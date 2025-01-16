package ec.com.sofka.utils.enums;


import ec.com.sofka.generics.interfaces.IValueObject;

public enum MatchStatusEnum implements IValueObject<String> {
    ACTIVE("Active"),
    FINISHED("Finished"),
    DRAW("Draw");

    private final String value;

    MatchStatusEnum(String value) {
        this.value = value;
    }

    @Override
    public String getValue() {
        return value;
    }
}
