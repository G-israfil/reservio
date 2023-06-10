package reservio.common.models.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import reservio.common.models.RelatedEntity;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CreateUpdateFloorFormInfo {
    private List<CreateUpdateTableFormInfo> tables;
    private int capacity;
    private Boolean stage = false;
    private int level;
}
