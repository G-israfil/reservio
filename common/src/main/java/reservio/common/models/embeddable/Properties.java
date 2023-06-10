package reservio.common.models.embeddable;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class Properties {
    private String name;
    private String description;
    private String value;
    private String note = null;
}
