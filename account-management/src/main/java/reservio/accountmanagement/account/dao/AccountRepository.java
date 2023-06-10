package reservio.accountmanagement.account.dao;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import reservio.accountmanagement.account.entitiy.Account;

@Repository
@Transactional
public interface AccountRepository extends JpaRepository<Account,Long> {
}
