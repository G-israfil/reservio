package reservio.common.models.response;

import lombok.Data;
import reservio.common.models.embeddable.RelatedEntity;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class PaymentMethodCreateUpdateResponse {

    private String description;

    private String type;

    private String name;

    private LocalDateTime createdDate;

    private LocalDateTime updatedDate;

    private String updatedBy;

    private String createdBy;

    private List<RelatedEntity> relatedEntities;
}
