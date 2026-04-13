package co.edu.ustavillavicencio.quiz_arias_diaz.dto.responses;

import co.edu.ustavillavicencio.quiz_arias_diaz.entities.Truck;
import lombok.*;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class TruckResponse {
    private UUID id;
    private String brand;
    private Double capacity;
    private String color;
    private String plate;
}
