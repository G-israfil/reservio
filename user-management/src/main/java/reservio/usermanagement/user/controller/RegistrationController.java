package reservio.usermanagement.user.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping("/auth")
public class RegistrationController {

    @PostMapping("/register")
    public void registerUser(){

    }


    // After the verification we should create a account for the user.
    public void verifyUser(){

    }

    public void validateInputs(){

    }

}
