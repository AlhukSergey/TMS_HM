package tmspaymentsystem;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Merchant {
    private String id;
    private String name;
    private List<BankAccount> bankAccounts;
    private final LocalDateTime createdAt;

    public Merchant(String name) {
        id = UUID.randomUUID().toString();
        this.name = name;
        bankAccounts = new ArrayList<>();
        createdAt = LocalDateTime.now();
    }

    public List<BankAccount> getBankAccounts() {
        return bankAccounts;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public String toString() {
        return id + " " + name + " " + createdAt;
    }
}
