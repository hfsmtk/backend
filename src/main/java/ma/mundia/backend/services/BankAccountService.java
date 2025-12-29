package ma.mundia.backend.services;

import ma.mundia.backend.dtos.BankAccountDTO;
import ma.mundia.backend.dtos.CurrentBankAccountDTO;
import ma.mundia.backend.dtos.CustomerDTO;
import ma.mundia.backend.dtos.SavingBankAccountDTO;
import ma.mundia.backend.entities.BankAccount;
import ma.mundia.backend.entities.CurrentAccount;
import ma.mundia.backend.entities.Customer;
import ma.mundia.backend.entities.SavingAccount;
import ma.mundia.backend.exceptions.BalanceNotSufficientException;
import ma.mundia.backend.exceptions.BankAccountNotFoundException;
import ma.mundia.backend.exceptions.CustomerNotFoundException;

import java.util.List;

public interface BankAccountService {
    CustomerDTO saveCustomer(CustomerDTO customerDTO);
    CurrentBankAccountDTO saveCurrentBankAccount(double initialBalance, double overDraft, Long customerID) throws CustomerNotFoundException;
    SavingBankAccountDTO saveSavingBankAccount(double initialBalance, double interestRate, Long customerID) throws CustomerNotFoundException;

    List<CustomerDTO> listCustomers();
    BankAccountDTO getBankAccount(String accountId) throws BankAccountNotFoundException;

    void debit(String accountId, double amount, String description) throws BankAccountNotFoundException, BalanceNotSufficientException;
    void credit(String accountId, double amount, String description) throws BankAccountNotFoundException;
    void transfer(String accountIdSource,String accountIdDestination, double amount) throws BankAccountNotFoundException, BalanceNotSufficientException;

    List<BankAccountDTO> bankAccountList();

    CustomerDTO getCustomer(Long customerID) throws CustomerNotFoundException;

    CustomerDTO updateCustomer(CustomerDTO customerDTO);

    void deleteCustomer(Long customerID) throws CustomerNotFoundException;
}
