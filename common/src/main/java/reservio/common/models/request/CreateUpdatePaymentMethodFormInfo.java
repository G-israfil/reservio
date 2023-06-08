package reservio.common.models.request;

import lombok.Data;
import reservio.common.models.RelatedEntity;

import java.util.List;

@Data
public class CreateUpdatePaymentMethodFormInfo {

    private String description;

    private String type;

    private String name;

    private List<RelatedEntity> relatedEntities;
}
