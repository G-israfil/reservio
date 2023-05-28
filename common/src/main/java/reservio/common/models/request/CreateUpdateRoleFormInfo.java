package reservio.common.models.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)

public class CreateUpdateRoleFormInfo {
    private String role;
    private String permissions;
    private String description;
    private String name;
}
