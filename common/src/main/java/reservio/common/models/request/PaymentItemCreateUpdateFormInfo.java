package reservio.common.models.request;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.Data;
import reservio.common.models.embeddable.Price;

@Data
public class PaymentItemCreateUpdateFormInfo {

        private String name;

        private String description;

        private Price itemPrice;
}
