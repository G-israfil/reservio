package reservio.ordermanagement.order.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

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

    @Column(name = "createdDate")
    @CreatedDate
    private LocalDateTime createdDate;

    @Column(name = "lastUpdatedDate")
    @LastModifiedDate
    private LocalDateTime lastUpdatedDate;


}
