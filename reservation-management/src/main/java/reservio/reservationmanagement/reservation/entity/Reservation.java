package reservio.reservationmanagement.reservation.entity;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import reservio.common.enums.STATUS;
import reservio.common.models.embeddable.RelatedEntity;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;


@Table(name = "reservations")
@Data
@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
@EntityListeners(AuditingEntityListener.class)
public class Reservation {
    @Id
    @Column(name = "reservationId")
    private Long id;

    @Column(name = "description")
    private String description;

    @Column(name = "reservationSize")
    private int reservationSize;

    @Column(name = "startDate")
    private LocalDateTime startDate;

    @Column(name = "endDate")
    private LocalDateTime endDate;

    @Column(name = "duration")
    private int duration;

    @Column(name = "createdDate")
    @CreatedDate
    private LocalDateTime createdDate;

    @Column(name = "lastUpdatedDate")
    @LastModifiedDate
    private LocalDateTime lastUpdatedDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private STATUS status;

    @Column(name = "updatedBy")
    private String updatedBy;


    // Restaurant table client
    @ElementCollection
    private List<RelatedEntity> relatedEntities;

    @Column(name = "version")
    @Version
    private int version;
    public Reservation(){
        id = UUID.fromString(UUID.randomUUID().toString()).getMostSignificantBits();
    }

}
