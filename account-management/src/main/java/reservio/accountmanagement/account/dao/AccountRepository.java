package reservio.accountmanagement.account.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import reservio.accountmanagement.account.entitiy.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account,Long> {
}
