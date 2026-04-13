package co.edu.ustavillavicencio.quiz_arias_diaz.services;

import co.edu.ustavillavicencio.quiz_arias_diaz.dto.requests.CreateTruckRequest;
import co.edu.ustavillavicencio.quiz_arias_diaz.dto.responses.TruckResponse;
import co.edu.ustavillavicencio.quiz_arias_diaz.entities.Truck;
import co.edu.ustavillavicencio.quiz_arias_diaz.repositories.TruckRepository;
import co.edu.ustavillavicencio.quiz_arias_diaz.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TruckService {

    private final TruckRepository truckRepository;
    private final UserRepository userRepo;

    public List<TruckResponse> findAll() {
        return truckRepository.findAll().stream()
                .map(truck -> TruckResponse.builder()
                        .id(truck.getId())
                        .brand(truck.getBrand())
                        .capacity(truck.getCapacity())
                        .color(truck.getColor())
                        .plate(truck.getPlate())
                        .build()
                ).toList();
    }

    public TruckResponse findById(UUID id) {
        Truck truck = truckRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Truck not found with id: " + id));
        return TruckResponse.builder()
                .id(truck.getId())
                .brand(truck.getBrand())
                .capacity(truck.getCapacity())
                .color(truck.getColor())
                .plate(truck.getPlate())
                .build();
    }

    public TruckResponse save(CreateTruckRequest request) {
        Truck truckToSave = Truck.builder()
                .brand(request.getBrand())
                .capacity(request.getCapacity())
                .color(request.getColor())
                .plate(request.getPlate())
                .userDriver(userRepo.findById(request.getUserDriverId()).orElseThrow(() -> new IllegalArgumentException("User not found: " + request.getUserDriverId())))
                .build();
        Truck saved = truckRepository.save(truckToSave);
        return TruckResponse.builder()
                .id(saved.getId())
                .brand(saved.getBrand())
                .capacity(saved.getCapacity())
                .color(saved.getColor())
                .plate(saved.getPlate())
                .build();
    }

    public TruckResponse update(UUID id, CreateTruckRequest request) {
        truckRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Truck not found with id: " + id));
        Truck truckToUpdate = Truck.builder()
                .id(id)
                .brand(request.getBrand())
                .capacity(request.getCapacity())
                .color(request.getColor())
                .plate(request.getPlate())
                .userDriver(userRepo.findById(request.getUserDriverId()).orElseThrow(() -> new IllegalArgumentException("User not found: " + request.getUserDriverId())))
                .build();
        Truck updated = truckRepository.save(truckToUpdate);
        return TruckResponse.builder()
                .id(updated.getId())
                .brand(updated.getBrand())
                .capacity(updated.getCapacity())
                .color(updated.getColor())
                .plate(updated.getPlate())
                .build();
    }

    public void delete(UUID id) {
        Truck truck = truckRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Truck not found with id: " + id));
        truckRepository.deleteById(truck.getId());
    }
}
