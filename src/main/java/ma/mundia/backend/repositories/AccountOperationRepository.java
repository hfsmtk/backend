package ma.mundia.backend.repositories;

import ma.mundia.backend.entities.AccountOperation;
import ma.mundia.backend.entities.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountOperationRepository extends JpaRepository<AccountOperation, Long> {
}
