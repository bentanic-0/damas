package ec.com.sofka.aggregates.auth.handler;

import ec.com.sofka.aggregates.auth.AuthAggregate;
import ec.com.sofka.aggregates.auth.entities.user.User;
import ec.com.sofka.aggregates.auth.entities.user.values.UserId;
import ec.com.sofka.aggregates.auth.entities.user.values.objects.Email;
import ec.com.sofka.aggregates.auth.entities.user.values.objects.Password;
import ec.com.sofka.aggregates.auth.entities.user.values.objects.Name;
import ec.com.sofka.aggregates.auth.entities.user.values.objects.Rating;
import ec.com.sofka.aggregates.auth.events.UserCreated;
import ec.com.sofka.aggregates.auth.events.UserUpdated;
import ec.com.sofka.generics.domain.DomainActionsContainer;

public class UserHandler extends DomainActionsContainer {

    public UserHandler(AuthAggregate authAggregate) {
        addDomainActions((UserCreated event) -> {
            User user = new User(
                    UserId.of(event.getUserId()),
                    Name.of(event.getFirstName()),
                    Name.of(event.getLastName()),
                    Email.of(event.getEmail()),
                    Password.of(event.getPassword()),
                    event.getRole(),
                    Rating.of(event.getRating())
            );
            authAggregate.setUser(user);
        });

        addDomainActions((UserUpdated event) -> {
            User user = new User(
                    UserId.of(event.getUserId()),
                    Name.of(event.getFirstName()),
                    Name.of(event.getLastName()),
                    Email.of(event.getEmail()),
                    Password.of(event.getPassword()),
                    event.getRole(),
                    Rating.of(event.getRating())
            );
            authAggregate.setUser(user);
        });
    }
}
