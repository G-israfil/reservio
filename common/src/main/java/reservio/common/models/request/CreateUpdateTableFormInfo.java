package reservio.common.models.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)

public class CreateUpdateTableFormInfo {
    private String state;
    private String capacity;
    private String price;
}
