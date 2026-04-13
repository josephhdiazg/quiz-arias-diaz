package co.edu.ustavillavicencio.quiz_arias_diaz.dto.responses;

import lombok.*;

@Data
@AllArgsConstructor
@Getter @Setter
@Builder
public class LoginResponse {
    private String token;
}
