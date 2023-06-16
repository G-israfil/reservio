package reservio.storagemanagement.inventory.entity;

import jakarta.persistence.*;
import lombok.Data;
import reservio.common.models.embeddable.Price;
import reservio.common.util.CommonUtils;

import java.util.List;

@Data
@Entity
@Table(name = "inventory")
public class InventoryRecord {

    @Column(name = "inventoryId")
    @Id
    private Long id = CommonUtils.generateUUID();
    private String name;
    private String description;
    private String type;
    private Double weight;
    private int quantity;
    private Long relatedRestaurantId;
    private Integer profitRate;
    @ElementCollection
    private List<Price> cost;
}
