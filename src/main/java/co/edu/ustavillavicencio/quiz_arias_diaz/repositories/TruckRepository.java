package co.edu.ustavillavicencio.quiz_arias_diaz.repositories;

import co.edu.ustavillavicencio.quiz_arias_diaz.entities.Truck;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TruckRepository extends JpaRepository<Truck, UUID> {
}
