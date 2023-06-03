package reservio.usermanagement.user.dao;


import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import reservio.usermanagement.user.entity.User;


@Repository
@Transactional
public interface UserRepository extends JpaRepository<User,Long> {

    public User findByUsername(@NonNull final String username);

    @Query("SELECT u FROM User u WHERE u.username = :usernameOrEmail OR u.email = :usernameOrEmail")
    public User findByUsernameOrEmail(@Param("usernameOrEmail") String usernameOrEmail);
}
