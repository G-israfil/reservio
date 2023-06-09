package reservio.paymentmanagement.paymentmethod.service;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import reservio.common.contant.Contants;
import reservio.common.enums.Status;
import reservio.common.exceptions.NotFoundException;
import reservio.common.mappers.ModelMapperHelper;
import reservio.common.models.request.CreateUpdatePaymentMethodFormInfo;
import reservio.common.models.response.PaymentMethodCreateUpdateResponse;
import reservio.paymentmanagement.paymentmethod.dao.PaymentMethodRepository;
import reservio.paymentmanagement.paymentmethod.entity.PaymentMethod;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class PaymentMethodService {

    private final PaymentMethodRepository repository;
    private final ModelMapperHelper modelMapperHelper;
    public PaymentMethodCreateUpdateResponse createPaymentMethod(@NonNull final CreateUpdatePaymentMethodFormInfo formInfo){
        log.info("Payment method creation started.. request => {}",formInfo);
        final PaymentMethod paymentMethod = modelMapperHelper.map(formInfo,PaymentMethod.class);
        paymentMethod.setStatus(Status.ACTIVE);
        return this.modelMapperHelper.map(this.repository.save(paymentMethod),PaymentMethodCreateUpdateResponse.class);
    }

    public PaymentMethodCreateUpdateResponse updatePaymentMethod(@NonNull final Long id,@NonNull final CreateUpdatePaymentMethodFormInfo formInfo){
        final Optional<PaymentMethod> optionalPaymentMethod = this.repository.findById(id);
        if (optionalPaymentMethod.isPresent()){
            final PaymentMethod updatedPaymentMethod = optionalPaymentMethod.get();
            updatedPaymentMethod.setName(formInfo.getName());
            updatedPaymentMethod.setType(formInfo.getType());
            updatedPaymentMethod.setDescription(formInfo.getDescription());

            //Not all should be set.

            return this.modelMapperHelper.map(this.repository.save(updatedPaymentMethod),PaymentMethodCreateUpdateResponse.class);
        }

        throw new NotFoundException(Contants.ErrorMessage.PAYMENT_METHOD_NOT_FOUND + String.valueOf(id));
    }
    public PaymentMethod getPaymentMethod(@NonNull final Long id){
        final Optional<PaymentMethod> optionalPaymentMethod = this.repository.findById(id);
        if (optionalPaymentMethod.isPresent()) return optionalPaymentMethod.get();

        throw new NotFoundException(Contants.ErrorMessage.PAYMENT_METHOD_NOT_FOUND + String.valueOf(id));
    }

    public PaymentMethod getPaymentMethodByType(@NonNull final String type){
        final List<PaymentMethod> paymentMethods = repository.findPaymentMethodByTypeAndStatus(type, Status.ACTIVE);

        if(ObjectUtils.isEmpty(paymentMethods)) throw new NotFoundException(Contants.ErrorMessage.DEFAULT_PAYMENT_METHOD_NOT_FOUND);
        return paymentMethods.get(0);
    }

    public void deletePaymentMethods(@NonNull final Long id){
        final Optional<PaymentMethod> optionalPaymentMethod = this.repository.findById(id);
        if(optionalPaymentMethod.isPresent()) this.repository.deleteById(id);

        throw new NotFoundException(Contants.ErrorMessage.PAYMENT_METHOD_NOT_FOUND + String.valueOf(id));
    }
}
