package reservio.usermanagement.user.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import reservio.common.models.response.UserCreateUpdateResponse;
import reservio.usermanagement.user.models.UserCreateUpdateFormInfo;
import reservio.usermanagement.user.services.UserService;

@Controller
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping("userManagement/auth")
public class RegistrationController {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<UserCreateUpdateResponse> registerUser(@RequestBody final UserCreateUpdateFormInfo formInfo){
        return ResponseEntity.ok(this.userService.createUser(formInfo));
    }


    // After the verification we should create a account for the user.
    public void verifyRegistrationRequest(final UserCreateUpdateFormInfo formInfo){

    }

}
