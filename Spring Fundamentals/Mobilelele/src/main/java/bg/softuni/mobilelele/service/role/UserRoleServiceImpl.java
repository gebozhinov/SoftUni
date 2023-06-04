package bg.softuni.mobilelele.service.role;

import bg.softuni.mobilelele.domain.entities.UserRole;
import bg.softuni.mobilelele.domain.enums.Role;
import bg.softuni.mobilelele.repositories.UserRoleRepository;
import bg.softuni.mobilelele.service.DataInitService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserRoleServiceImpl implements UserRoleService {

    private final UserRoleRepository userRoleRepository;

    public UserRoleServiceImpl(UserRoleRepository userRoleRepository) {
        this.userRoleRepository = userRoleRepository;
    }

    @Override
    public void fillDb() {
        if (!isDbFilled()) {
            List<UserRole> roles = new ArrayList<>();
            roles.add(new UserRole().setRole(Role.USER));
            roles.add(new UserRole().setRole(Role.ADMIN));

            this.userRoleRepository.saveAllAndFlush(roles);
        }

    }

    @Override
    public boolean isDbFilled() {
        return this.userRoleRepository.count() > 0;
    }
}
