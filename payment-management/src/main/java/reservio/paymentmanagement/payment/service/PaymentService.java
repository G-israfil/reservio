package reservio.paymentmanagement.payment.service;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import reservio.common.contant.Contants;
import reservio.common.exceptions.NotFoundException;
import reservio.common.mappers.ModelMapperHelper;
import reservio.common.models.request.CreateUpdatePaymentFormInfo;
import reservio.paymentmanagement.payment.dao.PaymentRepository;
import reservio.paymentmanagement.payment.entity.Payment;
import reservio.paymentmanagement.paymentmethod.entity.PaymentMethod;
import reservio.paymentmanagement.paymentmethod.service.PaymentMethodService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class PaymentService {
    private final PaymentRepository paymentRepository;
    private final ModelMapperHelper modelMapperHelper;
    private final PaymentMethodService paymentMethodService;

    public Payment createPayment(@NonNull @RequestBody final CreateUpdatePaymentFormInfo formInfo){
        final Payment payment = modelMapperHelper.map(formInfo, Payment.class);

        PaymentMethod paymentMethod = this.paymentMethodService.getPaymentMethod(Long.parseLong(formInfo.getPaymentMethodRef().getId()));

        return this.paymentRepository.save(payment);
    }

    public Payment updatePayment(@NonNull Long id, @NonNull @RequestBody final CreateUpdatePaymentFormInfo formInfo) {
        Optional<Payment> optionalPayment = paymentRepository.findById(id);
        if (optionalPayment.isPresent()) {
            Payment payment = optionalPayment.get();
            payment = modelMapperHelper.map(formInfo, Payment.class);
            payment.setId(id);
            return paymentRepository.save(payment);
        }
        throw new NotFoundException(Contants.ErrorMessage.PAYMENT_NOT_FOUND + id);
    }

    public Payment getPayment(@PathVariable @NonNull Long id) {
        Optional<Payment> optionalPayment = paymentRepository.findById(id);
        if (optionalPayment.isPresent()) {

            return optionalPayment.get();
        }
        throw new NotFoundException(Contants.ErrorMessage.PAYMENT_NOT_FOUND + id);
    }

    public List<Payment> listPayments(@PathVariable String name, String value) {
        //TODO: Implement the logic to list payments based on the provided parameters
        return null;
    }

    public void deletePayment(@PathVariable @NonNull Long id) {
        paymentRepository.deleteById(id);
    }

    public void refundPayment(@PathVariable String id) {
        //TODO: Implement the logic to refund the payment
    }
}
