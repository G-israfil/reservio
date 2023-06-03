package reservio.usermanagement.user.models;

import lombok.Data;
import reservio.usermanagement.enums.ROLE;

import java.util.Collection;
import java.util.List;

@Data
public class UserCreateUpdateFormInfo {

    private final String username;
    private final String password;
    private final String email;
    private final String name;
    private final String lastname;
    private final List<ROLE> roles;
}
