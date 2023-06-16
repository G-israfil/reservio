package reservio.paymentmanagement.paymentmethod.dao;

import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import reservio.common.enums.Status;
import reservio.paymentmanagement.paymentmethod.entity.PaymentMethod;

import java.util.List;
import java.util.Optional;

@Repository
public interface PaymentMethodRepository extends JpaRepository<PaymentMethod,Long> {
    List<PaymentMethod> findPaymentMethodByTypeAndStatus(@NonNull String type, Status status);
}
