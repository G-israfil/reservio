package reservio.common.models.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)

public class LoginFormInfo {

    private String username;
    private String email;
    private String emailOrUsername;
    private String password;
}
