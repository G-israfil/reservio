package reservio.subscriptionmanagement.controller;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import reservio.common.models.request.CreateUpdateSubscriptionFormInfo;
import reservio.subscriptionmanagement.entity.Subscription;
import reservio.subscriptionmanagement.services.SubscriptionService;

@Controller
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping("subscriptionManagement")
public class SubscriptionController {

    private final SubscriptionService subscriptionService;
    @PostMapping("/subscription")
    public ResponseEntity<Subscription> createSubscription(@RequestBody @NonNull final CreateUpdateSubscriptionFormInfo formInfo){
        return ResponseEntity.ok(this.subscriptionService.createSubscription(formInfo));
    }

    @PostMapping("/subscription/cancel/{id}")
    public ResponseEntity<String> cancelSubscription(@PathVariable @NonNull final Long id){
        this.subscriptionService.deactivateSubscription(id);
        return ResponseEntity.ok("Subscription cancelled successfully.");
    }

    @DeleteMapping("subscription/{id}")
    public ResponseEntity<String> deleteSubscription(@PathVariable @NonNull final Long id){
        this.subscriptionService.deleteSubscription(id);
        return ResponseEntity.ok("Subscription deleted successfully.");
    }

    @PostMapping("/subscription/activate/{id}")
    public ResponseEntity<String> activateSubscription(@PathVariable @NonNull final Long id){
        this.subscriptionService.activateSubscription(id);
        return ResponseEntity.ok("Subscription activated successfully.");
    }

    @PostMapping("/subscription/deactivate/{id}")
    public ResponseEntity<String> deactivateSubscription(@PathVariable @NonNull final Long id){
        this.subscriptionService.deactivateSubscription(id);
        return ResponseEntity.ok("Subscription deactivated successfully.");
    }

    @PostMapping("/subscription/suspend/{id}")
    public ResponseEntity<String> suspendSubscription(@PathVariable @NonNull final Long id){
        this.subscriptionService.suspendSubscription(id);
        return ResponseEntity.ok("Subscription suspended successfully.");
    }


    @PostMapping("/subscription/resume/{id}")
    public ResponseEntity<String> resumeSubscription(@PathVariable @NonNull final Long id){
        this.subscriptionService.resumeSubscription(id);
        return ResponseEntity.ok("Subscription resumed successfully.");
    }


    @PostMapping("/subscription/renew/{id}")
    public ResponseEntity<String> renewSubscription(@PathVariable @NonNull final Long id){
        this.subscriptionService.renewSubscription(id);
        return ResponseEntity.ok("Subscription renewed successfully.");
    }

    @PatchMapping("/subscription/{id}")
    public ResponseEntity<Subscription> updateSubscription(@PathVariable @NonNull final Long id,@RequestBody @NonNull final CreateUpdateSubscriptionFormInfo formInfo){
        return ResponseEntity.ok(this.subscriptionService.updateSubscription(id,formInfo));
    }

    @GetMapping("/subscription/{id}")
    public ResponseEntity<Subscription> getSubscription(@PathVariable @NonNull final Long id){
        return ResponseEntity.ok(this.subscriptionService.getSubscription(id));
    }
}
