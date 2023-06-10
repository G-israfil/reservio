package reservio.common.models.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import reservio.common.enums.AccountType;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CreateUpdateAccountFormInfo {
        private String userId;
        private AccountType type;
        private String description;
        private String paymentMethodId;
}
