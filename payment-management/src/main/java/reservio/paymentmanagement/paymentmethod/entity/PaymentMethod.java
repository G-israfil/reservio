package reservio.paymentmanagement.paymentmethod.entity;

import jakarta.persistence.*;
import lombok.Data;
import reservio.common.models.RelatedEntity;

import java.util.List;

@Data
@Entity
@Table(name = "payment_methods")
public class PaymentMethod {

    @Id
    @Column(name = "payment_method_id")
    private Long id;

    @Column(name = "description")
    private String description;

    @Column(name = "type")
    private String type;

    @Column(name = "name")
    private String name;

    @ElementCollection
    private List<RelatedEntity> relatedEntities;
}
