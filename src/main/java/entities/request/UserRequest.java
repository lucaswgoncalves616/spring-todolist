package entities.request;

import entities.User;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UserRequest {


    @NotBlank(message = "Digite um nome valido")
    private String name;
    @NotBlank(message = "Digite um email valido")
    private String email;
    @NotBlank @Size(min=6, max = 20)
    private String password;

    public UserRequest(User user) {
        this.name = user.getName();
        this.email = user.getEmail();
        this.password = user.getPassword();
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
