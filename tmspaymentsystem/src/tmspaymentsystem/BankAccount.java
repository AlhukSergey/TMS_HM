package tmspaymentsystem;

import java.time.LocalDateTime;
import java.util.UUID;

public class BankAccount {
    private String id;
    private String merchantId;
    private AccountStatus status;
    private String accountNumber;
    private LocalDateTime createdTime;

    public BankAccount(String merchantId, String accountNumber) {
        this.id = UUID.randomUUID().toString();
        this.merchantId = merchantId;
        status = AccountStatus.ACTIVE;
        this.accountNumber = accountNumber;
        createdTime = LocalDateTime.now();
    }

    public AccountStatus getStatus() {
        return status;
    }

    public void setStatus(AccountStatus status) {
        this.status = status;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public LocalDateTime getCreatedTime() {
        return createdTime;
    }

    public String toString() {
        return merchantId + " " + status.toString() + " " + accountNumber + " " + createdTime;
    }
}
