package ec.com.sofka.aggregates.auth.entities.user;

import ec.com.sofka.aggregates.auth.entities.user.values.UserId;
import ec.com.sofka.aggregates.auth.entities.user.values.objects.Email;
import ec.com.sofka.aggregates.auth.entities.user.values.objects.Name;
import ec.com.sofka.aggregates.auth.entities.user.values.objects.Password;
import ec.com.sofka.aggregates.auth.entities.user.values.objects.Rating;
import ec.com.sofka.generics.shared.Entity;
import ec.com.sofka.utils.enums.RoleEnum;


public class User extends Entity<UserId> {
    private Name firstName;
    private Name lastName;
    private Email email;
    private Password password;
    private RoleEnum role;
    private Rating rating;

    public User(UserId id, Name firstName, Name lastName, Email email, Password password, RoleEnum role, Rating rating) {
        super(id);
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.role = role;
        this.rating = rating;
    }

    public Name getFirstName() {
        return firstName;
    }

    public Name getLastName() {
        return lastName;
    }

    public Email getEmail() {
        return email;
    }

    public Password getPassword() {
        return password;
    }

    public RoleEnum getRole() {
        return role;
    }

    public Rating getRating() {
        return rating;
    }

    public void updateRating(Rating newRating) {
        this.rating = newRating;
    }

}
