package reservio.usermanagement.user.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import reservio.usermanagement.user.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    public User findByUsername(final String username);
}
