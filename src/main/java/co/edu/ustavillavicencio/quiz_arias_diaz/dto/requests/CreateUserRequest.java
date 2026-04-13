package co.edu.ustavillavicencio.quiz_arias_diaz.dto.requests;

import co.edu.ustavillavicencio.quiz_arias_diaz.entities.User;
import co.edu.ustavillavicencio.quiz_arias_diaz.enums.UserRole;
import lombok.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Data
@AllArgsConstructor
@Getter @Setter
@Builder
public class CreateUserRequest {
    private String username;
    private String password;
    private String role;

    public User toEntity() {
        PasswordEncoder bcrypt = new BCryptPasswordEncoder();
        String encryptedPassword = "{bcrypt}" + bcrypt.encode(this.password);
        UserRole role = switch (this.role.toUpperCase()) {
            case "ADMIN" -> UserRole.ADMIN;
            case "DRIVER" -> UserRole.DRIVER;
            default -> throw new IllegalStateException("Unexpected value: " + this.role);
        };

        return User.builder()
                .username(this.username)
                .password(encryptedPassword)
                .role(role)
                .build();
    }
}
