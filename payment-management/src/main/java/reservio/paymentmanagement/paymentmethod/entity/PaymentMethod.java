package reservio.paymentmanagement.paymentmethod.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import reservio.common.enums.STATUS;
import reservio.common.models.embeddable.Properties;
import reservio.common.models.embeddable.RelatedEntity;
import reservio.common.util.CommonUtils;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "payment_methods")
@EntityListeners(AuditingEntityListener.class)
public class PaymentMethod {

    @Id
    @Column(name = "paymentMethodId")
    private Long id = CommonUtils.generateUUID();

    @Column(name = "description")
    private String description;

    @Column(name = "type")
    private String type;

    @Column(name = "name")
    private String name;

    @Column(name = "satatus")
    @Enumerated(EnumType.STRING)
    private STATUS status;

    @Column(name = "created_date")
    @CreatedDate
    private LocalDateTime createdDate;

    @Column(name = "updated_date")
    @LastModifiedDate
    private LocalDateTime updatedDate;

    @Column(name = "updatedby")
    @LastModifiedBy
    private String updatedBy;

    @Column(name = "createdby")
    @CreatedBy
    private String createdBy;

    @ElementCollection
    private List<Properties> properties;
}
