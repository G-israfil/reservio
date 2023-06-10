package reservio.restaurantmanagement.table.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import reservio.common.models.embeddable.Position;
import reservio.common.models.embeddable.Price;
import reservio.common.models.embeddable.RelatedEntity;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "tables")
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@EntityListeners(AuditingEntityListener.class)
public class RTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "capacity", nullable = false)
    private int chair;

    @Column(name = "type")
    private String type;

    @CreatedDate
    @Column(name = "created_date")
    private LocalDateTime createdDate;

    @Column(name = "price", nullable = false)
    private Price price = null;

    @LastModifiedDate
    @Column(name = "updated_date")
    private LocalDateTime updatedDate;
    @Column(name = "createdby")
    @LastModifiedBy
    private String lastUpdatedBy;

    @Column(name = "createdby_r")
    private String createdBy;

    @Version
    private int version;

    @ElementCollection
    private List<RelatedEntity> relatedEntities;

    private Position position;
}
