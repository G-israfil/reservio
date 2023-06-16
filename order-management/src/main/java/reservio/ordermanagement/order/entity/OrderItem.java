package reservio.ordermanagement.order.entity;

import jakarta.persistence.*;
import lombok.Data;

import reservio.common.models.embeddable.Price;
import reservio.common.models.embeddable.Product;

@Entity
@Table(name = "orderItems")
@Data
public class OrderItem {

    @Column(name = "orderItemId")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "product")
    private Product product;

    @Column(name = "quantity")
    private int quantity;

}
