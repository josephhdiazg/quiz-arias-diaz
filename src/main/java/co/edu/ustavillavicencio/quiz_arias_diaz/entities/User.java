package co.edu.ustavillavicencio.quiz_arias_diaz.entities;

import co.edu.ustavillavicencio.quiz_arias_diaz.enums.UserRole;
import jakarta.persistence.*;
import lombok.*;
import java.util.UUID;

@Entity
@Table(name = "users")
@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String username;
    private String password;
    @Enumerated(EnumType.STRING)
    private UserRole role;
}
