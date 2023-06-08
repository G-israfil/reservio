package reservio.paymentmanagement.payment.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.UUID;

@Entity
@Table(name = "payment_items")
@Data
public class PaymentItem {

    @Id
    @Column(name = "payment_item_id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "item_price")
    private Double itemPrice;

    public PaymentItem(){
        id = UUID.fromString(UUID.randomUUID().toString()).getMostSignificantBits();
    }
}
