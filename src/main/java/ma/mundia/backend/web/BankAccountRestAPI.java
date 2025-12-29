package ma.mundia.backend.web;

import ma.mundia.backend.dtos.BankAccountDTO;
import ma.mundia.backend.exceptions.BankAccountNotFoundException;
import ma.mundia.backend.exceptions.CustomerNotFoundException;
import ma.mundia.backend.services.BankAccountService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BankAccountRestAPI {
    private BankAccountService bankAccountService;

    public BankAccountRestAPI(BankAccountService bankAccountService) {
        this.bankAccountService = bankAccountService;
    }
    @GetMapping("/accounts/{accountId}")
    public BankAccountDTO getBankAccount(@PathVariable String accountID) throws BankAccountNotFoundException {
        return bankAccountService.getBankAccount(accountID);
    }
    @GetMapping("/accounts")
    public List<BankAccountDTO> listAccounts() throws BankAccountNotFoundException {
        return bankAccountService.bankAccountList();
    }
}
