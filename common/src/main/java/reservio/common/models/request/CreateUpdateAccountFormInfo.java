package reservio.common.models.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import reservio.common.enums.ACCOUNT_TYPE;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CreateUpdateAccountFormInfo {
        private String userId;
        private ACCOUNT_TYPE type;
        private String description;
        private String paymentMethodId;
}
