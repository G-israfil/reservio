package reservio.paymentmanagement.payment.entity;


import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import reservio.common.enums.STATUS;
import reservio.common.models.RelatedEntity;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity(name = "payments")
@Table
@Data
@EntityListeners(AuditingEntityListener.class)
public class Payment {
    @Id
    @Column(name = "payment_id")
    private Long id;

    @Column(name = "type")
    private String type;

    @Column(name = "paymentItems")
    private String paymentItems;

    @Column(name = "totalPrice")
    private Double totalPrice;

    @Column(name = "description")
    private String description;

    @Column(name = "createdDate")
    @CreatedDate
    private LocalDateTime createdDate;

    @Column(name = "lastUpdatedDate")
    @LastModifiedDate
    private LocalDateTime lastUpdatedDate;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private STATUS status;

    @ElementCollection
    private List<RelatedEntity> relatedEntities;

    @Column(name = "updatedBy")
    private String updatedBy;

    @Column(name = "version")
    @Version
    private int version;

    public Payment(){
        id = UUID.fromString(UUID.randomUUID().toString()).getMostSignificantBits();
    }

}
