package reservio.common.models.embeddable;


import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.NonNull;

@Data
@Embeddable
public class RelatedEntity {
    private String name;
    private String type;
    private String value;
}
