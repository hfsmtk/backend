package ma.mundia.backend.dtos;

import jakarta.persistence.*;
import lombok.Data;
import ma.mundia.backend.enums.AccountStatus;
import java.util.Date;


@Data
public class SavingBankAccountDTO extends BankAccountDTO {
    @Id
    private String id;
    private double balance;
    private Date createdAt;
    @Enumerated(EnumType.STRING)
    private AccountStatus status;
    private CustomerDTO customerDTO;
    private double interestRate;
}
