package reservio.restaurantmanagement.restaurant.entity;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "restaurants")
@Data
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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
    @Enumerated(EnumType.STRING)
    private City city;

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

    @Column(name = "created_date")
    @CreatedDate
    private LocalDateTime createdDate;

    @Column(name = "last_updated_date")
    @LastModifiedDate
    private LocalDateTime lastUpdatedDate;

    public enum City {
        CITY1,
        CITY2,
        CITY3,
    }
}
