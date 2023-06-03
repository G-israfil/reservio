package reservio.subscriptionmanagement.controller;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping("subscriptionManagement")
public class SubscriptionController {

    @PostMapping("/subscription")
    public void createSubscription(){

    }

    @PostMapping("/subscription/cancel/{id}")
    public void cancelSubscription(@PathVariable @NonNull final String id){

    }

    @DeleteMapping("subscription/{id}")
    public void deleteSubscription(@PathVariable @NonNull final String id){

    }

    @PostMapping("/subscription/activate/{id}")
    public void activateSubscription(@PathVariable @NonNull final String id){

    }

    @PostMapping("/subscription/deactivate/{id}")
    public void deactivateSubscription(@PathVariable @NonNull final String id){

    }

    @PostMapping("/subscription/suspend/{id}")
    public void suspendSubscription(@PathVariable @NonNull final String id){

    }


    @PostMapping("/subscription/resume/{id}")
    public void resumeSubscription(){

    }


    @PostMapping("/subscription/renew/{id}")
    public void renewSubscription(@PathVariable @NonNull final String id){

    }

    @PatchMapping("/subscription/{id}")
    public void updateSubscription(@PathVariable @NonNull final String id,@RequestBody final String nmb){

    }
}
