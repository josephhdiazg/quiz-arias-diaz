package co.edu.ustavillavicencio.quiz_arias_diaz.services;

import co.edu.ustavillavicencio.quiz_arias_diaz.entities.User;
import co.edu.ustavillavicencio.quiz_arias_diaz.enums.UserRole;
import co.edu.ustavillavicencio.quiz_arias_diaz.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AppUserDetailsService implements UserDetailsService {
    private final UserRepository userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByUsername(username).orElseThrow(() -> new IllegalArgumentException("User not found: " + username));

        List<GrantedAuthority> authorities = switch (user.getRole()) {
            case UserRole.ADMIN -> List.of(new SimpleGrantedAuthority("ROLE_ADMIN"));
            case UserRole.DRIVER -> List.of(new SimpleGrantedAuthority("ROLE_DRIVER"));
        };

        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorities);
    }
}
