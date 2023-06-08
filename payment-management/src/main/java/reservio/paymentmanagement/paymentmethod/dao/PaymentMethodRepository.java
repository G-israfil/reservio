package reservio.paymentmanagement.paymentmethod.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import reservio.paymentmanagement.paymentmethod.entity.PaymentMethod;

@Repository
public interface PaymentMethodRepository extends JpaRepository<PaymentMethod,Long> {
}
