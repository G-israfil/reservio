package reservio.paymentmanagement.payment.controller;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import reservio.common.models.request.CreateUpdatePaymentFormInfo;
import reservio.paymentmanagement.payment.service.PaymentService;

@Controller
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping("/paymentManagement")
public class PaymentController {
    private final PaymentService paymentService;

    @PostMapping("/payment")
    public ResponseEntity createPayment(@NonNull @RequestBody final CreateUpdatePaymentFormInfo formInfo) {
        return ResponseEntity.ok(this.paymentService.createPayment(formInfo));
    }

    @PatchMapping("/payment/{id}")
    public ResponseEntity updatePayment(@PathVariable @NonNull final String id, @RequestBody @NonNull final CreateUpdatePaymentFormInfo formInfo) {
        return ResponseEntity.ok(this.paymentService.updatePayment(id, formInfo));
    }

    @DeleteMapping("/payment/{id}")
    public ResponseEntity<Void> deletePayment(@PathVariable @NonNull final String id) {
        paymentService.deletePayment(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/payment/{id}")
    public ResponseEntity getPayment(@PathVariable @NonNull final String id) {
        this.paymentService.getPayment(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/payment/refund/{id}")
    public ResponseEntity<Void> refundPayment(@PathVariable @NonNull final String id) {
        paymentService.refundPayment(id);
        return ResponseEntity.noContent().build();
    }
}
