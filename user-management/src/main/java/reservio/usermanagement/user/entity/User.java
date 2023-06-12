package reservio.usermanagement.user.entity;


import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import reservio.common.enums.Role;
import reservio.common.enums.Status;
import reservio.common.util.CommonUtils;


import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@EqualsAndHashCode
@Table(name = "users")
@JsonInclude(JsonInclude.Include.NON_NULL)
@EntityListeners(AuditingEntityListener.class)
public class User{
    @Id
    @Column(name = "userId")
    private Long id = CommonUtils.generateUUID();

    @Column(name = "name")
    private String name;


    @Column(name = "lastname")
    private String lastname;

    @Column(name = "email",unique = true)

    private String email;

    @Column(name = "username",unique = true)
    private String username;

    @Column(name = "roles")
    @Enumerated(EnumType.STRING)
    private List<Role> roles;

    @Column(name = "createdDate")
    @CreatedDate
    private LocalDateTime createdDate;

    @Column(name = "lastUpdatedDate")
    @LastModifiedDate
    private LocalDateTime lastUpdatedDate;

    @Column(name = "hash")
    private String hash;

    @Column(name = "password")
    private String password;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private Status status;


    @Column(name = "updatedBy")
    private String updatedBy;

    @Column(name = "locked")
    private Boolean locked = false;

    @Column(name = "credentialsNonExpired")
    private Boolean credentialsNonExpired = false;

    @Column(name = "enabled")
    private Boolean enabled = false;

    @Column(name = "version")
    @Version
    private int version;
}
