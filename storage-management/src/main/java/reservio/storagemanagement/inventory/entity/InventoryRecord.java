package reservio.storagemanagement.inventory.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import reservio.common.models.embeddable.Price;
import reservio.common.util.CommonUtils;

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
    private Price perSalePrice;
    private Integer profitRate;
    private Price cost;
}
