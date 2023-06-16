package reservio.usermanagement.user.controller;


import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import reservio.common.models.response.UserCreateUpdateResponse;
import reservio.usermanagement.user.models.UserCreateUpdateFormInfo;
import reservio.usermanagement.user.services.UserService;

import java.io.UnsupportedEncodingException;

@Controller
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping("userManagement")
public class UserController {
    private final UserService userService;
    @PostMapping("/user")
    public ResponseEntity<UserCreateUpdateResponse> createUser(@RequestBody final UserCreateUpdateFormInfo formInfo) throws UnsupportedEncodingException {
        return ResponseEntity.ok(this.userService.createUser(formInfo));
    }

    @PatchMapping ("/user/{id}")
    public ResponseEntity<UserCreateUpdateResponse> updateUser(@RequestBody final UserCreateUpdateFormInfo formInfo, @NonNull @PathVariable Long id){
        return ResponseEntity.ok(this.userService.updateUser(formInfo,id));
    }

    @DeleteMapping ("/user/{id}")
    public ResponseEntity<Void> deleteUser(@NonNull @PathVariable Long id){
        this.userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
    public void listUsers(){

    }
}
