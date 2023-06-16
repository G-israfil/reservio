package reservio.ordermanagement.order.entity;

import jakarta.persistence.*;
import lombok.Cleanup;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import reservio.common.enums.Status;

import java.time.LocalDateTime;
import java.util.List;

@Table(name = "order")
@Entity
@Data
public class Order {
    @Id
    @Column(name = "orderId")
    private Long id;

    @Column(name = "name")
    private String description;

    @Column(name = "type")
    private String type;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(name = "createdDate")
    @CreatedDate
    private LocalDateTime createdDate;

    @Column(name = "lastUpdatedDate")
    @LastModifiedDate
    private LocalDateTime lastUpdatedDate;

    @Column(name = "orderItems")
    @OneToMany
    private List<OrderItem> orderItems;

    @Column(name = "relatedUserId")
    private Long relatedUserId;

    @Column(name = "relatedRestaurantId")
    private Long relatedRestaurantId;

}
