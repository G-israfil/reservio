package reservio.paymentmanagement.payment.entity;

import jakarta.persistence.*;
import lombok.Data;
import reservio.common.models.embeddable.Price;
import reservio.common.util.CommonUtils;


@Entity
@Table(name = "payment_items")
@Data
public class PaymentItem {

    @Id
    @Column(name = "paymentItemId")
    private Long id = CommonUtils.generateUUID();

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "itemPrice")
    private Price itemPrice;

}
