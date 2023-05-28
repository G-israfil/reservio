package reservio.common.models.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import reservio.common.models.RelatedEntity;
import reservio.common.models.RoleRef;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserCreateUpdateFormInfo {

    private String username;
    private String name;
    private String lastname;
    private String password;
    private String email;
    private RoleRef role;
    private List<RelatedEntity> relatedEntities;
}
