package reservio.common.models.embeddable;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embeddable;
import lombok.Data;

import java.util.List;

@Embeddable
@Data
public class Product {

    private String name;
    private String description;
    private String type;
    private Price price;
    private Long specificationId;
    @ElementCollection
    private List<Properties> properties;
}
