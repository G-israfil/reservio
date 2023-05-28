package reservio.usermanagement.user.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@CrossOrigin("*")
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/auth")
public class AuthController {

    @GetMapping("/login")
    public void login(){
        log.info("login worked.");
    }
}
