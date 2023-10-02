package bg.softuni.Pathfinder.service;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class AppUserDetailService implements UserDetailsService {

    private final AuthService authService;

    public AppUserDetailService(AuthService authService) {
        this.authService = authService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var user = this.authService.findUserByUsername(username);

        return new User(
                user.getUsername(),
                user.getPassword(),
                user.getRoles().stream()
                        .map(role -> new SimpleGrantedAuthority(role.getRole().name()))
                        .collect(Collectors.toList())
        );
    }
}
