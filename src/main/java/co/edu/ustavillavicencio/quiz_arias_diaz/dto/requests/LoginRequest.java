package co.edu.ustavillavicencio.quiz_arias_diaz.dto.requests;

import lombok.*;

@Data
@AllArgsConstructor
@Getter @Setter
@Builder
public class LoginRequest {
    private String username, password;
}
