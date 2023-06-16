package reservio.common.models.request;


import lombok.Data;

@Data
public class CreateUpdateInventoryRecordFormInfo {

    private Long id;
    private String name;
    private String description;
    private String type;
    private Double weight;
    private int quantity;
    private Long relatedEntityId;
}
