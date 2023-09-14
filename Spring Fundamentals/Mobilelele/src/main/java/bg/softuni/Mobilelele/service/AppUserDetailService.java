package bg.softuni.Mobilelele.service;

import bg.softuni.Mobilelele.model.entity.UserEntity;
import bg.softuni.Mobilelele.model.entity.UserRoleEntity;
import bg.softuni.Mobilelele.model.user.CurrentUserDetails;
import bg.softuni.Mobilelele.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

public class AppUserDetailService implements UserDetailsService {


    private final UserRepository userRepository;

    public AppUserDetailService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return this.userRepository.findByUsername(username)
                .map(this::map)
                .orElseThrow(() -> new UsernameNotFoundException(username + " not found!"));
    }

    private UserDetails map(UserEntity userEntity) {
        return new CurrentUserDetails(
                userEntity.getFirstName(),
                userEntity.getLastName(),
                userEntity.getUsername(),
                userEntity.getPassword(),
                List.of(this.map(userEntity.getRole()))
        );
    }
    private GrantedAuthority map(UserRoleEntity userRole) {
        return new SimpleGrantedAuthority(
                userRole.getRole().name());
    }
}
