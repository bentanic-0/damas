package ec.com.sofka.generics.shared;

//10. Generics creation to apply DDD: Request - Abstract class to generate request/commands
public abstract class Command {
    private final String aggregateId;

    protected Command(String aggregateId) {
        this.aggregateId = aggregateId;
    }

    public String getAggregateId() {
        return aggregateId;
    }
}
