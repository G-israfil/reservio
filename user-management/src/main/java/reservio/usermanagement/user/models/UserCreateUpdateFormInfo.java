package reservio.usermanagement.user.models;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import reservio.common.enums.Role;


import java.util.List;

@Getter
@Setter
public class UserCreateUpdateFormInfo {

    @NonNull
    private String username;
    @NonNull
    private String password;
    @NonNull
    private String email;
    @NonNull
    private String name;
    @NonNull
    private String lastname;
    @NonNull
    private List<Role> roles;
}

