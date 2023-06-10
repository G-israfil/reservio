package reservio.productcatalogmanagement.productcatalog.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import reservio.common.enums.STATUS;
import reservio.common.models.embeddable.Price;
import reservio.common.models.embeddable.Properties;

import java.time.LocalDateTime;
import java.util.List;

@Table(name = "product_specifications")
@Entity
@Data
@EntityListeners(AuditingEntityListener.class)
public class ProductSpecification {
    @Id
    @Column(name = "product_specification_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "type")
    private String type;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "createdDate")
    @CreatedDate
    private LocalDateTime createdDate;

    @Column(name = "price")
    private Price price;

    @ElementCollection
    private List<Properties> properties;

    @Column(name = "lastUpdatedDate")
    @LastModifiedDate
    private LocalDateTime lastUpdatedDate;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private STATUS status;

    @Column(name = "updatedBy")
    private String updatedBy;

    @Column(name = "version")
    @Version
    private int version;

}
