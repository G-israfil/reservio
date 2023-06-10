package reservio.common.models.embeddable;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class Position {
    private int x;
    private int y;
    private int angle;
}
