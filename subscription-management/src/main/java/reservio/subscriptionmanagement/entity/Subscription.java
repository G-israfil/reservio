package reservio.subscriptionmanagement.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import reservio.common.models.RelatedEntity;

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
    private List<RelatedEntity> relatedEntities;
    @Column(name = "version")
    @Version
    private int version;
    public Subscription(){
        id = UUID.fromString(UUID.randomUUID().toString()).getMostSignificantBits();
    }

    @ElementCollection
    private List<RelatedEntity> payments;

    @ElementCollection
    private List<RelatedEntity> relatedPersons;

    @ElementCollection
    private List<RelatedEntity> relatedOrganizations;
}
