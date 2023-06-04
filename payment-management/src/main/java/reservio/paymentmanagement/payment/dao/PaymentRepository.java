package reservio.paymentmanagement.payment.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import reservio.paymentmanagement.payment.entity.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment,Long> {
}
