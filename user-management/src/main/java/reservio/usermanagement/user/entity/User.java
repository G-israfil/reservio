package reservio.usermanagement.user.entity;


import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import reservio.usermanagement.ROLE;


import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.UUID;
import java.util.stream.Collectors;

@Entity
@Data
@Table(name = "users")
public class User implements UserDetails{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

//    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.REMOVE)
//    @JoinTable(name = "user_roles",
//            joinColumns = @JoinColumn(name = "user_id"),
//            inverseJoinColumns = @JoinColumn(name = "role_id"))
//    private Collection<Role> roles;


    @Column(name = "roles")
    @Enumerated(EnumType.STRING)
    private Collection<ROLE> roles;

    @Column(name = "createdDate")
    @CreatedDate
    private LocalDateTime createdDate;

    @Column(name = "updatedDate")
    @LastModifiedDate
    private LocalDateTime updatedDate;

    @Column(name = "hash")
    private String hash;

    @Column(name = "salt")
    private String salt;

    @Column(name = "status")
    private String status;

    @Column(name = "orderHistory")
    private String orderHistory;

    @Column(name = "reservationHistory")
    private String reservationHistory;

    @Column(name = "paymentMethods")
    private String paymentMethods;

    @Column(name = "updatedBy")
    private String updatedBy;

    @Column(name = "locked")
    private Boolean locked;

    @Column(name = "credentialsNonExpired")
    private Boolean credentialsNonExpired;

    @Column(name = "enabled")
    private Boolean enabled;

    @Column(name = "version")
    @Version
    private int version;
    public User(){
        id = UUID.fromString(UUID.randomUUID().toString()).getMostSignificantBits();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        //        final List<SimpleGrantedAuthority> authorities = new ArrayList<>();
//        roles.stream().forEach(role -> authorities.add(new SimpleGrantedAuthority(role.name())));
//
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
        return locked;
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
