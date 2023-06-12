package reservio.usermanagement.user.controller;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import reservio.common.models.request.LoginFormInfo;
import reservio.common.models.response.LoginResponse;
import reservio.common.models.response.UserCreateUpdateResponse;
import reservio.usermanagement.user.models.UserCreateUpdateFormInfo;
import reservio.usermanagement.user.services.UserService;

import java.io.UnsupportedEncodingException;

@Controller
@CrossOrigin("*")
@RequiredArgsConstructor
@Slf4j
@RequestMapping("userManagement/auth")
public class AuthController {
    private final UserService userService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody @Validated @NonNull final LoginFormInfo formInfo) throws UnsupportedEncodingException {
        return ResponseEntity.ok(this.userService.login(formInfo));
    }

    @PostMapping("/register")
    public ResponseEntity<UserCreateUpdateResponse> registerUser(@RequestBody @Validated @NonNull final UserCreateUpdateFormInfo formInfo) throws UnsupportedEncodingException {
        return ResponseEntity.ok(this.userService.createUser(formInfo));
    }
}
