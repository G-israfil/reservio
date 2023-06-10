package reservio.paymentmanagement.paymentmethod.entity;

import jakarta.persistence.*;
import lombok.Data;
import reservio.common.models.embeddable.RelatedEntity;

import java.time.LocalDateTime;
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

    @Column(name = "created_date")
    private LocalDateTime createdDate;

    @Column(name = "updated_date")
    private LocalDateTime updatedDate;

    @Column(name = "updatedby")
    private String updatedBy;

    @Column(name = "createdby")
    private String createdBy;

    @ElementCollection
    private List<RelatedEntity> relatedEntities;
}
