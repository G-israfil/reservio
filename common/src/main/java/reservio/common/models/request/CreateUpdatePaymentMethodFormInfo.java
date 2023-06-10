package reservio.common.models.request;

import lombok.Data;
import reservio.common.models.embeddable.Properties;
import reservio.common.models.embeddable.RelatedEntity;

import java.util.List;

@Data
public class CreateUpdatePaymentMethodFormInfo {

    private String description;

    private String type;

    private String name;

    private List<Properties> properties;
}
