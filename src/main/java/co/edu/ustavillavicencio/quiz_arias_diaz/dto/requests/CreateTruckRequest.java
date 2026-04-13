package co.edu.ustavillavicencio.quiz_arias_diaz.dto.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;

import java.util.UUID;


@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@Builder
public class CreateTruckRequest {
    @NotBlank(message = "Brand cannot be empty")
    private String brand;

    @NotNull(message = "Capacity is required")
    @Positive(message = "Capacity must be greater than zero")
    private Double capacity;

    @NotBlank(message = "Color cannot be empty")
    private String color;

    @NotBlank(message = "Plate cannot be empty")
    private String plate;

    @NotNull(message = "Driver ID is required")
    private UUID userDriverId;
}
