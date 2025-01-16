package ec.com.sofka.data;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.io.Serializable;

@Schema(description = "Object representing the data to update a user.")
public class UserUpdateRequestDTO implements Serializable {

    @Schema(description = "Aggregate ID of the user", example = "123")
    @NotNull(message = "aggregateId cannot be null")
    private String aggregateId;

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
    @Email(message = "Invalid email format")
    private String email;

    @Schema(description = "Password of the user", example = "password123")
    @NotNull(message = "password cannot be null")
    @Size(min = 8, message = "password must be at least 8 characters long")
    private String password;

    @Schema(description = "Role of the user", example = "USER")
    @NotNull(message = "role cannot be null")
    @Pattern(regexp = "^(USER|ADMIN)$", message = "Incorrect role")
    private String userRole;

    public UserUpdateRequestDTO(String aggregateId, String firstName, String lastName, String email, String password, String userRole) {
        this.aggregateId = aggregateId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.userRole = userRole;
    }

    public UserUpdateRequestDTO() {
    }

    public String getAggregateId() {
        return aggregateId;
    }

    public void setAggregateId(String aggregateId) {
        this.aggregateId = aggregateId;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }
}