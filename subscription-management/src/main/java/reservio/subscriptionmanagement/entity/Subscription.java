package reservio.subscriptionmanagement.entity;

<<<<<<< Updated upstream:subscription-management/src/main/java/reservio/subscriptionmanagement/model/Subscription.java
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
=======
import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
>>>>>>> Stashed changes:subscription-management/src/main/java/reservio/subscriptionmanagement/entity/Subscription.java
import reservio.common.models.RelatedEntity;

import java.time.LocalDateTime;
import java.util.List;
<<<<<<< Updated upstream:subscription-management/src/main/java/reservio/subscriptionmanagement/model/Subscription.java
import java.util.UUID;
=======
>>>>>>> Stashed changes:subscription-management/src/main/java/reservio/subscriptionmanagement/entity/Subscription.java

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@EntityListeners(AuditingEntityListener.class)
@Entity
@Table(name = "subscriptions")
public class Subscription {

    @Id
    @Column(name = "subscription_id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "duration")
    private String duration;

    @Column(name = "term")
    private String term;

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
    private String currentCycle;

    @Column(name = "totalCycle")
    private String totalCycle;

    @ElementCollection
<<<<<<< Updated upstream:subscription-management/src/main/java/reservio/subscriptionmanagement/model/Subscription.java
    private List<RelatedEntity> relatedEntities;
    @Column(name = "version")
    @Version
    private int version;
    public Subscription(){
        id = UUID.fromString(UUID.randomUUID().toString()).getMostSignificantBits();
    }

=======
    private List<RelatedEntity> payments;

    @ElementCollection
    private List<RelatedEntity> relatedPersons;

    @ElementCollection
    private List<RelatedEntity> relatedOrganizations;
>>>>>>> Stashed changes:subscription-management/src/main/java/reservio/subscriptionmanagement/entity/Subscription.java
}
