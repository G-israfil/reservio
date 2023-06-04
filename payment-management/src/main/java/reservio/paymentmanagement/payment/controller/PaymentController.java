package reservio.paymentmanagement.payment.controller;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import reservio.paymentmanagement.payment.service.PaymentService;

@Controller
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping("/paymentManagement")
public class PaymentController {
    private final PaymentService paymentService;
    @PostMapping("/payment")
    public void createPayment(@RequestBody @NonNull String requestBody){

    }
    @PatchMapping("/payment/{id}")
    public void updatePayment(@NonNull @PathVariable String id,@RequestBody @NonNull String requestBody){

    }

    @GetMapping("/payment/{id}")
    public void getPayment(@NonNull @PathVariable String id){

    }

    @GetMapping("/payment")
    public void listPayments(@RequestParam @NonNull String name,@RequestParam @NonNull String value){

    }


    @DeleteMapping("/payment/{id}")
    public void deletePayment(@NonNull @PathVariable String id){

    }

    @PostMapping("/payment/refund")
    public void refundPayment(){

    }

}
