package ec.com.sofka.data;

import java.io.Serializable;

public class UserResponseDTO implements Serializable {
    private String firstName;
    private String lastName;
    private String email;
    private String role;

    public UserResponseDTO(String firstName, String lastName, String email, String role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.role = role;
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

    public String getRole() {
        return role;
    }
}