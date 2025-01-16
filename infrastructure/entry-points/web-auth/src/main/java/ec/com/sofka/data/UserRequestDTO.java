package ec.com.sofka.data;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.io.Serializable;

@Schema(description = "Object representing the data to create or update a user.")
public class UserRequestDTO implements Serializable {

    @Schema(description = "First name of the user", example = "John")
    @NotNull(message = "firstName cannot be null")
    @Size(max = 50, message = "firstName exceeds allowed length")
    private String firstName;

    @Schema(description = "Last name of the user", example = "Doe")
    @NotNull(message = "lastName cannot be null")
    @Size(max = 50, message = "lastName exceeds allowed length")
    private String lastName;

    @Schema(description = "Email of the user", example = "john.doe@example.com")
    @NotNull(message = "email cannot be null")
    @Pattern(regexp = "^[A-Za-z0-9+_.-]+@(.+)$", message = "Incorrect email format")
    private String email;

    @Schema(description = "Password of the user", example = "password123")
    @NotNull(message = "password cannot be null")
    @Size(min = 8, message = "password must be at least 8 characters long")
    private String password;

    @Schema(description = "Role of the user", example = "USER")
    @NotNull(message = "role cannot be null")
    @Pattern(regexp = "^(USER|ADMIN)$", message = "Incorrect role")
    private String role;

    public UserRequestDTO(String firstName, String lastName, String email, String password, String role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    // Getters
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

    public String getRole() {
        return role;
    }
}