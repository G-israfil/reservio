package reservio.common.models.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import reservio.common.models.embeddable.Position;
import reservio.common.models.embeddable.Price;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CreateUpdateTableFormInfo {
    private int chair;
    private Price price;
    private String type;
    private Position position;
}
