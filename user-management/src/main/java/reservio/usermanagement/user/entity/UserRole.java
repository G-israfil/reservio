package reservio.usermanagement.user.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Entity
@Table(name = "user_roles")
@Data
@IdClass(UserRoleId.class)
public class UserRole {

    @Id
    @Column(name = "user_id")
    private Long userId;
    @Id
    @Column(name = "role_id")
    private Long roleId;
}
