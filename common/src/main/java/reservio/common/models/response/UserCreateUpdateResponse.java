package reservio.common.models.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import reservio.common.enums.ROLE;
import reservio.common.models.RelatedEntity;
import reservio.common.models.RoleRef;

import java.time.LocalDateTime;
import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserCreateUpdateResponse {
    private String username;
    private String name;
    private String lastname;
    private String password;
    private String email;
    private RoleRef role;
    private List<ROLE> roles;
    private List<RelatedEntity> relatedEntities;
    private LocalDateTime createdDate;
    private LocalDateTime lastUpdatedDate;
    private String createdBy;
    private String updatedBy;
    private String status;
}
