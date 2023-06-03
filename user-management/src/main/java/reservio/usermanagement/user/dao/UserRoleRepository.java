package reservio.usermanagement.user.dao;

import jakarta.transaction.Transactional;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import reservio.usermanagement.user.entity.UserRoleId;
import reservio.usermanagement.user.entity.UserRole;

import java.util.List;

@Repository
@Transactional
public interface UserRoleRepository extends JpaRepository<UserRole,UserRoleId> {

    @Modifying
    @Query("INSERT INTO UserRole (userId, roleId) VALUES(:userId,:roleId)")
    public UserRole assignRole(@Param("userId") final @NonNull Long userId, @Param("roleId") final @NonNull Long roleId);

    public List<UserRole> getUserRolesByUserId(final @NonNull Long userId);

    public void deleteByRoleIdAndUserId(final @NonNull Long roleId, final @NonNull Long userId);

}
