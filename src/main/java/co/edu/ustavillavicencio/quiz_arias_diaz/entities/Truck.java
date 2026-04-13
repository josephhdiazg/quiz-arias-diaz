package co.edu.ustavillavicencio.quiz_arias_diaz.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name="truck")
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@Builder
public class Truck {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String brand;

    @Column(nullable = false)
    private Double capacity;

    @Column(nullable = false)
    private String color;

    @Column(nullable = false, unique = true)
    private String plate;

    @ManyToOne
    @JoinColumn(name = "user_driver_id")
    @JsonBackReference
    private User userDriver;
}

