package reservio.common.models.request;

import lombok.Data;
import reservio.common.models.embeddable.Price;
import reservio.common.models.embeddable.Properties;

import java.util.List;

@Data
public class CreateUpdateProductSpecificationFormInfo {
    private String name;
    private String description;
    private String type;
    private Price price;
    private List<Properties> properties;
}
