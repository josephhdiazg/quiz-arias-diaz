package co.edu.ustavillavicencio.quiz_arias_diaz.services;

import co.edu.ustavillavicencio.quiz_arias_diaz.dto.requests.CreateUserRequest;
import co.edu.ustavillavicencio.quiz_arias_diaz.dto.responses.UserResponse;

import java.util.List;
import java.util.UUID;

public interface UserService {
    List<UserResponse> index();
    UserResponse create(CreateUserRequest request);
    UserResponse show(UUID userId);
    void destroy(UUID userId);
}
