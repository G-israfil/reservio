package reservio.common.models.request;

import lombok.Data;
import reservio.common.models.embeddable.Price;
import reservio.common.models.embeddable.Product;

@Data
public class CreateUpdateOrderItemFormInfo {

    private Product product;
    private int quantity;
    private Price totalPrice;
}
