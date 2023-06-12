package reservio.common.models.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LoginResponse {

    private String username;
    private String email;
    private String token;
    private String expired;
    private String tokenType;
    private String refreshToken;
}
