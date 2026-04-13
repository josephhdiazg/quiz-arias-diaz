package co.edu.ustavillavicencio.quiz_arias_diaz.services.impl;

import co.edu.ustavillavicencio.quiz_arias_diaz.dto.requests.CreateUserRequest;
import co.edu.ustavillavicencio.quiz_arias_diaz.dto.responses.UserResponse;
import co.edu.ustavillavicencio.quiz_arias_diaz.repositories.UserRepository;
import co.edu.ustavillavicencio.quiz_arias_diaz.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository repo;

    @Override
    public List<UserResponse> index() {
        return repo.findAll().stream().map(UserResponse::fromEntity).toList();
    }

    @Override
    public UserResponse create(CreateUserRequest request) {
        return UserResponse.fromEntity(repo.save(request.toEntity()));
    }

    @Override
    public UserResponse show(UUID userId) {
        return UserResponse.fromEntity(repo.findById(userId).orElseThrow(
                () -> new IllegalArgumentException("User not found: " + userId)
        ));
    }

    @Override
    public void destroy(UUID userId) {
        repo.deleteById(userId);
    }
}
