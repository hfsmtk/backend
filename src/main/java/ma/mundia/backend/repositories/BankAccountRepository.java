package ma.mundia.backend.repositories;

import ma.mundia.backend.entities.BankAccount;
import ma.mundia.backend.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankAccountRepository extends JpaRepository<BankAccount, String> {
}
