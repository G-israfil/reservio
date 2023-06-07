package reservio.common.models.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class CreateUpdatePaymentFormInfo {
    private String type;
    private String paymentItems;
    private Double totalPrice;
    private String description;
    private String status;
    private String updatedBy;
}
