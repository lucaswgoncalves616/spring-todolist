package entities.response;

import entities.User;
import jakarta.validation.constraints.NotBlank;

public class UserResponse {

    @NotBlank
    private String name;
    @NotBlank
    private String email;

    public UserResponse(User user) {
        this.name = getName();
        this.email = getEmail();
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}
