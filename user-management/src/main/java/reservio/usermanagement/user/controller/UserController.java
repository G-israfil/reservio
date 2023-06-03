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
@RequestMapping("userManagement")
public class UserController {
    private final UserService userService;
    @PostMapping("/user")
    public ResponseEntity<UserCreateUpdateResponse> createUser(@RequestBody final UserCreateUpdateFormInfo formInfo){
        return ResponseEntity.ok(this.userService.createUser(formInfo));
    }

    public void updateUser(){

    }

    public void deleteUser(){

    }
    public void listUsers(){

    }

}
