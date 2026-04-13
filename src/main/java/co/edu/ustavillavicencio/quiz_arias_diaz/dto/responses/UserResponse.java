package co.edu.ustavillavicencio.quiz_arias_diaz.dto.responses;

import co.edu.ustavillavicencio.quiz_arias_diaz.entities.User;
import co.edu.ustavillavicencio.quiz_arias_diaz.enums.UserRole;
import lombok.*;

@Data
@AllArgsConstructor
@Getter
@Setter
@Builder
public class UserResponse {
    private String username;
    private String role;

    public static UserResponse fromEntity(User u) {
        String role = switch (u.getRole()) {
            case UserRole.ADMIN -> "ADMIN";
            case UserRole.DRIVER -> "DRIVER";
        };

        return UserResponse.builder()
                .username(u.getUsername())
                .role(role)
                .build();
    }
}
