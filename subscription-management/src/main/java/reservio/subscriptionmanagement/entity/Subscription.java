package reservio.subscriptionmanagement.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import reservio.common.enums.STATUS;
import reservio.common.enums.SUBSCRIPTION_TYPES;
import reservio.common.models.embeddable.Period;
import reservio.common.models.embeddable.Properties;
import reservio.common.models.embeddable.RelatedEntity;
import reservio.common.util.CommonUtils;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;


@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@EntityListeners(AuditingEntityListener.class)
@Entity
@Table(name = "subscriptions")
public class Subscription {

    @Id
    @Column(name = "subscription_id")
    private Long id = CommonUtils.generateUUID();

    @Column(name = "name")
    private String name;

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private SUBSCRIPTION_TYPES type;

    @Column(name = "description")
    private String description;



    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private STATUS status;

    @Column(name = "createdDate")
    @CreatedDate
    private LocalDateTime createdDate;

    @Column(name = "updatedDate")
    @LastModifiedDate
    private LocalDateTime updatedDate;

    @Column(name = "startedDate")
    private LocalDateTime startedDate;

    @Column(name = "expectedExpiryDate")
    private LocalDateTime expectedExpiryDate;

    @Column(name = "currentCycle")
    private int currentCycle;

    @Column(name = "totalCycle")
    private int totalCycle;

    @ElementCollection
    private List<RelatedEntity> relatedEntities;
    @Column(name = "version")
    @Version
    private int version;

    @ElementCollection
    private List<RelatedEntity> payments;

    @ElementCollection
    private List<RelatedEntity> relatedPersons;

    @ElementCollection
    private List<RelatedEntity> relatedOrganizations;

    @ElementCollection
    private List<Properties> properties;

    @Column(name = "period")
    private Period period;
}
