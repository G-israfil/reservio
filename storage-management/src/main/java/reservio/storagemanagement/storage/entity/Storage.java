package reservio.storagemanagement.storage.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import reservio.common.models.embeddable.Price;

@Data
@Entity
@Table(name = "storage")
public class Storage {

    @Id
    @Column(name = "storageId")
    private Long id;

    private String type;
    private String description;
    private Long relatedRestaurantId;
    private Integer totalVolume;
    private Integer emptyVolume;
    private Integer fullVolume;
    private Integer occupancyRate;
    private Price monthlyCost;
}
