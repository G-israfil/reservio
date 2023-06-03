package reservio.common.models.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LoginResponse {
    private final String token;
    private final String expired;
    private final String tokentype;
    private final String refreshToken;
}
