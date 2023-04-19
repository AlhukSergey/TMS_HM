package tmspaymentsystem;

import java.time.LocalDateTime;

public class BankAccount {
    private int merchantId;
    private AccountStatus status;
    private String accountNumber;
    private final LocalDateTime createdTime;

    public BankAccount(int merchantId, String accountNumber) {
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

    public int getMerchantId() {
        return merchantId;
    }

    public LocalDateTime getCreatedTime() {
        return createdTime;
    }

    public String toString() {
        return merchantId + " " + status.toString() + " " + accountNumber + " " + createdTime;
    }
}
