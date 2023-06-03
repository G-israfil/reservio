package reservio.usermanagement.user.models;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import reservio.usermanagement.enums.ROLE;

import java.time.LocalDateTime;
import java.util.Collection;

@Data
public class UserResponse {

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

    @Column(name = "password")
    private String password;

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
}
