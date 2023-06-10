package reservio.paymentmanagement.paymentmethod.controller;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import reservio.common.models.request.CreateUpdatePaymentMethodFormInfo;
import reservio.common.models.response.PaymentMethodCreateUpdateResponse;
import reservio.paymentmanagement.paymentmethod.entity.PaymentMethod;
import reservio.paymentmanagement.paymentmethod.service.PaymentMethodService;

@Controller
@RequiredArgsConstructor
@RequestMapping("/paymentManagement")
public class PaymentMethodController {

    private final PaymentMethodService paymentMethodService;
    @PostMapping("/paymentMethod")
    public ResponseEntity<PaymentMethodCreateUpdateResponse> createPaymentMethod(@RequestBody @NonNull final CreateUpdatePaymentMethodFormInfo formInfo){
        return ResponseEntity.ok(this.paymentMethodService.createPaymentMethod(formInfo));
    }

    @PatchMapping("/paymentMethod/{id}")
    public ResponseEntity<PaymentMethodCreateUpdateResponse> updatePaymentMethod(@PathVariable @NonNull Long id,@RequestBody @NonNull final CreateUpdatePaymentMethodFormInfo formInfo){
        return ResponseEntity.ok(this.paymentMethodService.updatePaymentMethod(id,formInfo));
    }

    @DeleteMapping("/paymentMethod/{id}")
    public ResponseEntity<Void> deletePaymentMethod(@PathVariable @NonNull Long id){
        this.paymentMethodService.deletePaymentMethods(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/paymentMethod/{id}")
    public ResponseEntity<PaymentMethod> getPaymentMethod(@PathVariable @NonNull Long id){
        return ResponseEntity.ok(this.paymentMethodService.getPaymentMethod((id)));
    }
}
