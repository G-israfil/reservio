package reservio.common.models.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)

public class PaymentUpdateCreateFormInfo {

    private Double amount;
    private String payerId;
    private String tableId;
    private String reservationId;
}
