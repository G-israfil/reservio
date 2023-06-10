package reservio.accountmanagement.account.controller;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import reservio.accountmanagement.account.service.AccountService;
import reservio.common.enums.Status;
import reservio.common.models.request.CreateUpdateAccountFormInfo;
import reservio.common.models.response.AccountCreateUpdateResponse;

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
    public ResponseEntity<AccountCreateUpdateResponse> getAccount(@NonNull @PathVariable Long id){
        return ResponseEntity.ok(this.accountService.getAccount(id));
    }

    @PatchMapping("/account/{id}")
    public ResponseEntity<AccountCreateUpdateResponse> updateAccount(@NonNull @PathVariable Long id,@NonNull @RequestBody final CreateUpdateAccountFormInfo formInfo){
        return ResponseEntity.ok(this.accountService.updateAccount(id, formInfo));
    }

    @DeleteMapping("/account/{id}")
    public ResponseEntity<String> deleteAccount(@NonNull @PathVariable Long id){
        this.accountService.deleteAccount(id);
        return ResponseEntity.ok("Account deleted successfully");
    }

    @PostMapping("/account/deactivate/{id}")
    public ResponseEntity<AccountCreateUpdateResponse> deactivateAccount(@NonNull @PathVariable Long id){
        return ResponseEntity.ok(this.accountService.handleActivateAndDeactivateAccount(id, Status.DEACTIVATED));
    }

    @PostMapping("/account/suspend/{id}")
    public ResponseEntity<AccountCreateUpdateResponse> suspendAccount(@NonNull @PathVariable Long id){
        return ResponseEntity.ok(this.accountService.handleActivateAndDeactivateAccount(id, Status.SUSPENDED));
    }

    @PostMapping("/account/resume/{id}")
    public ResponseEntity<AccountCreateUpdateResponse> resumeAccount(@NonNull @PathVariable Long id){
        return ResponseEntity.ok(this.accountService.handleActivateAndDeactivateAccount(id, Status.ACTIVE));
    }
}
