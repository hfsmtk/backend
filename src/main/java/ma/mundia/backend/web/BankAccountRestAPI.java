package ma.mundia.backend.web;

import ma.mundia.backend.dtos.AccountHistoryDTO;
import ma.mundia.backend.dtos.AccountOperationDTO;
import ma.mundia.backend.dtos.BankAccountDTO;
import ma.mundia.backend.exceptions.BankAccountNotFoundException;
import ma.mundia.backend.exceptions.CustomerNotFoundException;
import ma.mundia.backend.services.BankAccountService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
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
    @GetMapping("/accounts/{accountId}/operations")
    public List<AccountOperationDTO> getHistory(@PathVariable String accountID)  {
        return bankAccountService.accountHistory(accountID);
    }

    @GetMapping("/accounts/{accountId}/pageOperations")
    public AccountHistoryDTO gatAccountHistory(
            @PathVariable String accountId,
            @RequestParam(name = "page",defaultValue = "0") int page,
            @RequestParam(name = "size",defaultValue = "5") int size) throws BankAccountNotFoundException {
        return bankAccountService.getAccountHistory(accountId,page,size);
    }
}
