package reservio.common.models.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CreateUpdateSubscriptionFormInfo {

    private Long id;
    private String name;
    private String description;
    private String duration;
    private String term;
    private LocalDateTime startedDate;
    private LocalDateTime expectedExpiryDate;
    private String currentCycle;
    private String totalCycle;

}
