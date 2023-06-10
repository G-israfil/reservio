package reservio.common.models.embeddable;

import jakarta.persistence.Embeddable;
import lombok.Data;
import reservio.common.enums.Term;

@Data
@Embeddable
public class Period {
    private Term term;
    private long duration;
    private int mealsPerDayDuration;
}
