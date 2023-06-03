package reservio.usermanagement.user.services;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import reservio.usermanagement.enums.ROLE;
import reservio.usermanagement.user.dao.UserRepository;
import reservio.usermanagement.user.dao.UserRoleRepository;
import reservio.usermanagement.user.entity.User;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserRoleService {

    private final UserRoleRepository repository;
    private final UserRepository userRepository;

    public void assignRole(@NonNull final String roleId,@NonNull final String userId) {
        log.info("Role assignment started for user {} role {}", userId, roleId);
        ROLE[] roles = ROLE.values();
        final Optional<User> optionalUser = this.userRepository.findById(Long.parseLong(userId));

        if (optionalUser.isPresent()) {
            log.info("User update started for user {}", userId);
            final User user = optionalUser.get();
            log.info("User find. User => {}", user.toString());
            user.getRoles().add(roles[Integer.parseInt(roleId)]);
            log.info("User Roles => {}",user.getRoles());
            this.userRepository.save(user);
            log.info("User update completed successfully.");
        }
    }

    public void unAssignRole() {

    }

    public void createRole() {

    }

    public void updateRole() {

    }

    public void deleteRole() {

    }

    public void listUserRoles() {

    }
}
