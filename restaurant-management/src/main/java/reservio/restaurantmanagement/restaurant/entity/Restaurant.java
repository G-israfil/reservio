package reservio.restaurantmanagement.restaurant.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import jakarta.persistence.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import reservio.common.util.CommonUtils;
import reservio.restaurantmanagement.floor.entity.Floor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "restaurants")
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@EntityListeners(AuditingEntityListener.class)
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = CommonUtils.generateUUID();

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "phone", nullable = false)
    private String phone;

    @Column(name = "manager_name", nullable = false)
    private String managerName;

    @Column(name = "manager_phone")
    private String managerPhone;

    @Column(name = "contact_email", nullable = false)
    private String contactEmail;

    @Column(name = "description")
    private String description;

    @Column(name = "country", nullable = false)
    private String country;

    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "delivery")
    private Boolean delivery;

    @Column(name = "pickup")
    private Boolean pickup;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "floor",nullable = false)
    private int floorCount;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Floor> floors;

    @Column(name = "ownerId")
    private Long ownerId;

    @Column(name = "created_date")
    @CreatedDate
    private LocalDateTime createdDate;

    @Column(name = "last_updated_date")
    @LastModifiedDate
    private LocalDateTime lastUpdatedDate;

}
