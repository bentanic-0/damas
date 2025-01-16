package ec.com.sofka.aggregates.auth;

import ec.com.sofka.aggregates.auth.entities.user.User;
import ec.com.sofka.aggregates.auth.events.UserCreated;
import ec.com.sofka.aggregates.auth.events.UserUpdated;
import ec.com.sofka.aggregates.auth.handler.UserHandler;
import ec.com.sofka.aggregates.auth.values.AuthAggregateId;
import ec.com.sofka.generics.shared.AggregateRoot;
import ec.com.sofka.generics.domain.DomainEvent;
import ec.com.sofka.utils.enums.RoleEnum;

import java.util.List;

public class AuthAggregate extends AggregateRoot<AuthAggregateId> {
    private User user;

    public AuthAggregate() {
        super(new AuthAggregateId());
        setSubscription(new UserHandler(this));
    }

    public AuthAggregate(final String id) {
        super(AuthAggregateId.of(id));
        setSubscription(new UserHandler(this));
    }

    public void createUser(String firstName, String lastName, String email, String password, RoleEnum role, Integer rating) {
        addEvent(new UserCreated(new AuthAggregateId().getValue(), firstName, lastName, email, password, role, rating));
    }

    public static AuthAggregate from(String id, List<DomainEvent> events) {
        AuthAggregate authAggregate = new AuthAggregate();
        events.forEach(event -> authAggregate.addEvent(event).apply());
        authAggregate.markEventsAsCommitted();
        return authAggregate;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void updateUser(String aggregateId, String firstName, String lastName, String email, String password, RoleEnum role, Integer rating) {
        addEvent(new UserUpdated(aggregateId, firstName, lastName, email, password, role, rating));
    }
}
