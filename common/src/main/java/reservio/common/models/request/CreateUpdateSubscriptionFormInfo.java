package reservio.common.models.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import reservio.common.enums.SubscriptionType;
import reservio.common.models.embeddable.Period;
import reservio.common.models.embeddable.Properties;
import reservio.common.models.embeddable.RelatedEntity;

import java.time.LocalDateTime;
import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CreateUpdateSubscriptionFormInfo {
    private String name;
    private String description;
    private String duration;
    private String term;
    private SubscriptionType type;
    private LocalDateTime startedDate;
    private LocalDateTime expectedExpiryDate;
    private String currentCycle;
    private String totalCycle;

    private List<RelatedEntity> payments;
    private List<RelatedEntity> relatedPersons;
    private List<RelatedEntity> relatedOrganizations;
    private List<Properties> properties;
    private Period period;
}
