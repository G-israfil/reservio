package reservio.common.models.embeddable;

import jakarta.persistence.Embeddable;
import lombok.Data;
import reservio.common.enums.TERMS;

@Data
@Embeddable
public class Period {
    private TERMS term;
    private long duration;
    private int mealsPerDayDuration;
}
