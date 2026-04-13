package co.edu.ustavillavicencio.quiz_arias_diaz.controllers.api;

import co.edu.ustavillavicencio.quiz_arias_diaz.dto.requests.CreateUserRequest;
import co.edu.ustavillavicencio.quiz_arias_diaz.dto.responses.UserResponse;
import co.edu.ustavillavicencio.quiz_arias_diaz.services.UserService;
import lombok.*;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserRestController {
    private final UserService service;

    @PostMapping
    public UserResponse create(@RequestBody CreateUserRequest request) {
        return service.create(request);
    }

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public List<UserResponse> index() {
        return service.index();
    }

    @GetMapping("{userId}")
    @PreAuthorize("hasRole('ADMIN')")
    public UserResponse show(@PathVariable UUID userId) {
        return service.show(userId);
    }

    @DeleteMapping("{userId}")
    @PreAuthorize("hasRole('ADMIN')")
    public void destroy(@PathVariable UUID userId) {
        service.destroy(userId);
    }
}
