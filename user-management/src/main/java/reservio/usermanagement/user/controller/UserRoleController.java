package reservio.usermanagement.user.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import reservio.usermanagement.user.services.UserRoleService;

@Controller
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping("user/{userId}/role")
public class UserRoleController {

    private final UserRoleService userRoleService;
    @PostMapping("/{roleId}")
    public ResponseEntity assignRole(@PathVariable final String roleId, @PathVariable final String userId){
        return ResponseEntity.ok("Role successfully assigned...");
    }

    public void unAssignRole(){

    }

    public void createRole(){

    }
    public void updateRole(){

    }
    public void deleteRole(){

    }

    public void listUserRoles(){

    }
}
