package ec.com.sofka.aggregates.auth.events;

import ec.com.sofka.generics.domain.DomainEvent;
import ec.com.sofka.utils.enums.EventsEnum;
import ec.com.sofka.utils.enums.RoleEnum;

public class UserUpdated extends DomainEvent {
    private final String userId;
    private final String firstName;
    private final String lastName;
    private final String email;
    private final String password;
    private final RoleEnum role;
    private final Integer rating;


    public UserUpdated(String userId, String firstName, String lastName, String email, String password, RoleEnum role, Integer rating) {
        super(EventsEnum.USER_UPDATED.getEventType());
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.role = role;
        this.rating = rating;
    }

    public String getUserId() {
        return userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public RoleEnum getRole() {
        return role;
    }

    public Integer getRating() {
        return rating;
    }
}
