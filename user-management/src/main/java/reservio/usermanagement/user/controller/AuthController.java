package reservio.usermanagement.user.controller;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import reservio.common.models.request.LoginFormInfo;
import reservio.common.models.response.LoginResponse;
import reservio.usermanagement.user.services.UserService;

@Controller
@CrossOrigin("*")
@RequiredArgsConstructor
@Slf4j
@RequestMapping("userManagement/auth")
public class AuthController {
    private final UserService userService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody @NonNull final LoginFormInfo formInfo){
        return ResponseEntity.ok(this.userService.login(formInfo));
    }
}
