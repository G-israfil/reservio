package reservio.accountmanagement.account.controller;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import reservio.accountmanagement.account.entitiy.Account;
import reservio.accountmanagement.account.service.AccountService;
import reservio.common.enums.STATUS;
import reservio.common.models.request.CreateUpdateAccountFormInfo;
import reservio.common.models.response.AccountCreateUpdateResponse;

import java.awt.image.VolatileImage;
import java.util.Optional;

@Controller
@RequestMapping("/accountManagement")
@CrossOrigin("*")
@RequiredArgsConstructor
public class AccountController{

    private final AccountService accountService;
    @PostMapping("/account")
    public ResponseEntity<AccountCreateUpdateResponse> createAccount(@NonNull @RequestBody final CreateUpdateAccountFormInfo formInfo){
        return ResponseEntity.ok(this.accountService.createAccount(formInfo));
    }

    @GetMapping("/account/{id}")
    public ResponseEntity<AccountCreateUpdateResponse> getAccount(@NonNull @PathVariable String id){
        return ResponseEntity.ok(this.accountService.handleActivateAndDeactivateAccount(id, STATUS.ACTIVE));
    }

    @PatchMapping("/account/{id}")
    public ResponseEntity<AccountCreateUpdateResponse> updateAccount(@NonNull @PathVariable String id){
        return ResponseEntity.ok(this.accountService.handleActivateAndDeactivateAccount(id, STATUS.ACTIVE));
    }

    @DeleteMapping("/account/{id}")
    public ResponseEntity<String> deleteAccount(@NonNull @PathVariable String id){
        this.accountService.deleteAccount(id);
        return ResponseEntity.ok("Account deleted successfully");
    }

    @PostMapping("/account/deactivate/{id}")
    public ResponseEntity<AccountCreateUpdateResponse> deactivateAccount(@NonNull @PathVariable String id){
        return ResponseEntity.ok(this.accountService.handleActivateAndDeactivateAccount(id, STATUS.DEACTIVATED));
    }

    @PostMapping("/account/suspend/{id}")
    public ResponseEntity<AccountCreateUpdateResponse> suspendAccount(@NonNull @PathVariable String id){
        return ResponseEntity.ok(this.accountService.handleActivateAndDeactivateAccount(id, STATUS.SUSPENDED));
    }

    @PostMapping("/account/resume/{id}")
    public ResponseEntity<AccountCreateUpdateResponse> resumeAccount(@NonNull @PathVariable String id){
        return ResponseEntity.ok(this.accountService.handleActivateAndDeactivateAccount(id, STATUS.ACTIVE));
    }
}
