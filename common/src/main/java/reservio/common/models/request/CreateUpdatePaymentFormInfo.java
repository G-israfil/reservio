package reservio.common.models.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import reservio.common.models.embeddable.Price;
import reservio.common.models.embeddable.RelatedEntity;
import reservio.common.models.referances.PaymentMethodRef;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class CreateUpdatePaymentFormInfo {
    private String type;
    private List<PaymentItemCreateUpdateFormInfo> paymentItems;
    private List<RelatedEntity> relatedEntities;
    private Price totalPrice;
    private String description;
    private String status;
    private PaymentMethodRef paymentMethodRef;
}
