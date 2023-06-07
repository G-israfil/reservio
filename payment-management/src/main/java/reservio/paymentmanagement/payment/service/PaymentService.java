package reservio.paymentmanagement.payment.service;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import reservio.common.enums.STATUS;
import reservio.common.mappers.ModelMapperHelper;
import reservio.common.models.request.CreateUpdatePaymentFormInfo;
import reservio.paymentmanagement.payment.dao.PaymentRepository;
import reservio.paymentmanagement.payment.entity.Payment;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class PaymentService {
    private final PaymentRepository paymentRepository;
    private final ModelMapperHelper modelMapperHelper;

    public Payment createPayment(@NonNull @RequestBody CreateUpdatePaymentFormInfo formInfo){
        final Payment payment = modelMapperHelper.map(formInfo, Payment.class);
        return this.paymentRepository.save(payment);
    }

    public Optional<Payment> updatePayment(@NonNull String id, @NonNull CreateUpdatePaymentFormInfo formInfo) {
        Optional<Payment> optionalPayment = paymentRepository.findById(Long.valueOf(id));
        if (optionalPayment.isPresent()) {
            Payment payment = optionalPayment.get();
            // Update the payment entity with the new values
            payment.setType(formInfo.getType());
            payment.setPaymentItems(formInfo.getPaymentItems());
            payment.setTotalPrice(formInfo.getTotalPrice());
            payment.setDescription(formInfo.getDescription());
            payment.setStatus(STATUS.valueOf(formInfo.getStatus()));
            payment.setUpdatedBy(formInfo.getUpdatedBy());
            payment.setLastUpdatedDate(LocalDateTime.now());
            payment.setVersion(payment.getVersion() + 1);

            return Optional.of(paymentRepository.save(payment));
        }
        return Optional.empty();
    }

    public Optional<Payment> getPayment(@NonNull String id) {
        return paymentRepository.findById(Long.valueOf(id));
    }

    public Iterable<Payment> listPayments(String name, String value) {
        //TODO: Implement the logic to list payments based on the provided parameters
        return null;
    }

    public void deletePayment(@NonNull String id) {
        paymentRepository.deleteById(Long.valueOf(id));
    }

    public void refundPayment(String id) {
        //TODO: Implement the logic to refund the payment
    }
}
