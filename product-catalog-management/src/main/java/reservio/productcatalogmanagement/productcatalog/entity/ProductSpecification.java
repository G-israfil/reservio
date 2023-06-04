package reservio.productcatalogmanagement.productcatalog.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import reservio.common.enums.STATUS;

import java.time.LocalDateTime;
import java.util.UUID;

@Table(name = "product_specifications")
@Entity
@Data
public class ProductSpecification {
    @Id
    @Column(name = "product_specification_id")
    private Long id;

    @Column(name = "type")
    private String type;

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

    @Column(name = "updatedBy")
    private String updatedBy;

    @Column(name = "version")
    @Version
    private int version;

    public ProductSpecification(){
        id = UUID.fromString(UUID.randomUUID().toString()).getMostSignificantBits();
    }
}
