package reservio.usermanagement.user.entity;


import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import reservio.common.enums.ROLE;
import reservio.common.enums.STATUS;


import java.time.LocalDateTime;
import java.util.Collection;
import java.util.UUID;
import java.util.stream.Collectors;

@Entity
@Data
@EqualsAndHashCode
@Table(name = "users")
@JsonInclude(JsonInclude.Include.NON_NULL)
@EntityListeners(AuditingEntityListener.class)
public class User implements UserDetails{
    @Id
    @Column(name = "userId")
    private Long id;

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
    private Collection<ROLE> roles;

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
    private STATUS status;


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
    public User(){
        id = UUID.fromString(UUID.randomUUID().toString()).getMostSignificantBits();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.name())).collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return hash;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !locked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }
}
