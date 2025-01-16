package ec.com.sofka.queries.responses;

import ec.com.sofka.utils.enums.RoleEnum;

import java.io.Serializable;

public class UserResponse implements Serializable {
    private String firstName;
    private String lastName;
    private String email;
    private RoleEnum role;
    private Integer rating;


    public UserResponse(String firstName, String lastName, String email, RoleEnum role, Integer rating) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.role = role;
        this.rating = rating;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public RoleEnum getRole() {
        return role;
    }

    public void setRole(RoleEnum role) {
        this.role = role;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }
}
