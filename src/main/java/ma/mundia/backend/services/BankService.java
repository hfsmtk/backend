package ma.mundia.backend.services;


import jakarta.transaction.Transactional;
import ma.mundia.backend.entities.BankAccount;
import ma.mundia.backend.entities.CurrentAccount;
import ma.mundia.backend.entities.SavingAccount;
import ma.mundia.backend.repositories.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class BankService {
    @Autowired
    public BankAccountRepository bankAccountRepository;
    public void consulter(){
        BankAccount bankAccount=
                bankAccountRepository.findById("058edc81-3464-410a-bf07-344820785e85").orElse(null);
        if(bankAccount!=null) {
            System.out.println("**************");
            System.out.println(bankAccount.getId());
            System.out.println(bankAccount.getBalance());
            System.out.println(bankAccount.getStatus());
            System.out.println(bankAccount.getCreatedAt());
            System.out.println(bankAccount.getCustomer().getName());
            System.out.println(bankAccount.getClass().getSimpleName());
            if (bankAccount instanceof CurrentAccount) {
                System.out.println("Over Draft=>" + ((CurrentAccount) bankAccount).getOverDraft());
            } else if (bankAccount instanceof SavingAccount) {
                System.out.println("Rate=>" + ((SavingAccount) bankAccount).getInterestRate());
            }
            bankAccount.getAccountOperations().forEach(op -> {
                System.out.println(op.getType() + "\t" + op.getOperationDate() + "\t" + op.getAmount());
            });
        }
    }
}
