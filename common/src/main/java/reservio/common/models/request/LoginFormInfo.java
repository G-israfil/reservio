package reservio.common.models.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
public class LoginFormInfo {
    private String emailOrUsername;
    private String password;
}
