package reservio.paymentmanagement.payment.entity;


import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import reservio.common.enums.Status;
import reservio.common.models.embeddable.Price;
import reservio.common.models.embeddable.RelatedEntity;
import reservio.common.util.CommonUtils;
import reservio.paymentmanagement.paymentmethod.entity.PaymentMethod;

import java.time.LocalDateTime;
import java.util.List;

@Entity(name = "payments")
@Table
@Data
@EntityListeners(AuditingEntityListener.class)
public class Payment {
    @Id
    @Column(name = "payment_id")
    private Long id = CommonUtils.generateUUID();

    @Column(name = "type")
    private String type;

    @Column(name = "paymentItems")
    @OneToMany(cascade = CascadeType.ALL)
    private List<PaymentItem> paymentItems;

    @Column(name = "totalPrice")
    private Price totalPrice;

    @Column(name = "description")
    private String description;

    @Column(name = "duration")
    private String duration;

    @Column(name = "createdDate")
    @CreatedDate
    private LocalDateTime createdDate;

    @ManyToOne()
    private PaymentMethod paymentMethod;

    @Column(name = "lastUpdatedDate")
    @LastModifiedDate
    private LocalDateTime lastUpdatedDate;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private Status status;

    @ElementCollection
    private List<RelatedEntity> relatedEntities;

    @Column(name = "updatedBy")
    private String updatedBy;


    private Boolean isCyclePayment = false;
    private int totalCycle = 0;
    private int remainingCycle = 0;
    @Column(name = "version")
    @Version
    private int version;

}
