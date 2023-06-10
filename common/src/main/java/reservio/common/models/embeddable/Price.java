package reservio.common.models.embeddable;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class Price {
    private Double amount;
    private String unit;
}
