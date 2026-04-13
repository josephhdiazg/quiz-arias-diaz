package co.edu.ustavillavicencio.quiz_arias_diaz.controllers.api;

import co.edu.ustavillavicencio.quiz_arias_diaz.dto.requests.CreateTruckRequest;
import co.edu.ustavillavicencio.quiz_arias_diaz.dto.responses.TruckResponse;
import co.edu.ustavillavicencio.quiz_arias_diaz.services.TruckService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/trucks")
@RequiredArgsConstructor
public class TruckRestController {

    private final TruckService truckService;

    @GetMapping
    public ResponseEntity<List<TruckResponse>> getAll() {
        return ResponseEntity.ok(truckService.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<TruckResponse> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(truckService.findById(id));
    }

    @PostMapping
    public ResponseEntity<TruckResponse> create(@Valid @RequestBody CreateTruckRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(truckService.save(request));
    }

    @PutMapping("{id}")
    public ResponseEntity<TruckResponse> update(@PathVariable UUID id, @Valid @RequestBody CreateTruckRequest request) {
        return ResponseEntity.ok(truckService.update(id, request));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        truckService.delete(id);
        return ResponseEntity.noContent().build();
    }
}