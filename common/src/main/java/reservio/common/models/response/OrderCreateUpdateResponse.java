package reservio.common.models.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderCreateUpdateResponse {
    private String userId;
    private int accountId;
    private int payment;
    private int paymentId;
    private String paymentType;
    private String orderItem;
    private String description;
    private String orderType;

}
