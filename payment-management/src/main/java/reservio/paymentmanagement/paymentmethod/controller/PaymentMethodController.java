package reservio.paymentmanagement.paymentmethod.controller;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/paymentManagement")
public class PaymentMethodController {

    @PostMapping("/paymentMethod")
    public void createPaymentMethod(){

    }

    @PostMapping("/paymentMethod/{id}")
    public void updatePaymentMethod(@PathVariable @NonNull String id){

    }

    @PostMapping("/paymentMethod/{id}")
    public void deletePaymentMethod(@PathVariable @NonNull String id){

    }

    @GetMapping("/paymentMethod/{id}")
    public void getPaymentMethod(@PathVariable @NonNull String id){

    }
}
