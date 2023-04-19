package tmspaymentsystem;

import tmspaymentsystem.exceptions.BankAccountNotFoundException;
import tmspaymentsystem.exceptions.MerchantNotFoundException;
import tmspaymentsystem.exceptions.NoBankAccountsFoundException;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class MerchantService implements FilesPaths {
    private List<Merchant> merchants = new ArrayList<>();

    public void addBankAccount(Merchant merchant, BankAccount bankAccount) throws IllegalArgumentException {
        validAccountNumber(bankAccount.getAccountNumber());
        List<BankAccount> accounts = merchant.getBankAccounts();
        Optional<BankAccount> account = accounts.stream().filter(s -> s.getAccountNumber().equals(bankAccount.getAccountNumber())).findAny();
        account.filter(s -> s.getStatus().equals(AccountStatus.DELETED)).ifPresent(s -> s.setStatus(AccountStatus.ACTIVE));
        if (account.isPresent()) {
            account.get();
        } else {
            accounts.add(bankAccount);
            FileService.writeToFile(ACCOUNTS_FILE, bankAccount.toString());
        }
    }

    public List<BankAccount> getMerchantBankAccounts(Merchant merchant) throws NoBankAccountsFoundException {
        if (merchant.getBankAccounts().isEmpty()) {
            throw new NoBankAccountsFoundException("This merchant has no any bank account yet.");
        } else {
            return merchant.getBankAccounts().stream().sorted(Comparator.comparing(BankAccount::getCreatedTime)).sorted(Comparator.comparing(BankAccount::getStatus)).toList();
        }
    }

    public BankAccount updateBankAccount(BankAccount bankAccount, String newAccountNumber) throws BankAccountNotFoundException, IllegalArgumentException {
        validAccountNumber(newAccountNumber);
        List<BankAccount> accounts = mergeAccounts(merchants);
        Optional<BankAccount> account = accounts.stream().filter(s -> s.getAccountNumber().equals(bankAccount.getAccountNumber())).findAny();
        if (account.isPresent()) {
            account.get().setAccountNumber(newAccountNumber);
            FileService.updateFile(ACCOUNTS_FILE, accounts.stream().map(BankAccount::toString).toList());
            return account.get();
        } else {
            throw new BankAccountNotFoundException("No such bank account found!");
        }
    }

    public boolean deleteBankAccount(BankAccount bankAccount) throws BankAccountNotFoundException {
        List<BankAccount> accounts = mergeAccounts(merchants);
        if (accounts.contains(bankAccount)) {
            accounts.remove(bankAccount);
            FileService.updateFile(ACCOUNTS_FILE, accounts.stream().map(BankAccount::toString).toList());
            return true;
        } else {
            throw new BankAccountNotFoundException("No such bank account found!");
        }
    }

    public Merchant createMerchant(Merchant merchant) {
        merchants.add(merchant);
        FileService.writeToFile(MERCHANT_FILE, merchant.toString());
        return merchant;
    }

    public List<Merchant> getMerchants() {
        return merchants;
    }

    public Merchant getMerchantById(String id) throws MerchantNotFoundException {
        Optional<Merchant> merchant = merchants.stream().filter(s -> s.getId().equals(id)).findAny();
        if (merchant.isPresent()) {
            return merchant.get();
        } else {
            throw new MerchantNotFoundException("No such merchant found!");
        }
    }

    public boolean deleteMerchant(String id) throws MerchantNotFoundException {
        Optional<Merchant> merchant = merchants.stream().filter(s -> s.getId().equals(id)).findAny();
        if (merchant.isPresent()) {
            merchants.remove(merchant.get());
            FileService.updateFile(MERCHANT_FILE, merchants.stream().map(Merchant::toString).toList());
            return true;
        } else {
            throw new MerchantNotFoundException("No such merchant found!");
        }
    }

    private List<BankAccount> mergeAccounts(List<Merchant> merchants) {
        List<BankAccount> accounts = new ArrayList<>();
        merchants.stream().map(Merchant::getBankAccounts).forEach(accounts::addAll);
        return accounts;
    }

    private void validAccountNumber(String bankAccount) throws IllegalArgumentException {
        if (!bankAccount.matches("[0-9]{8}")) {
            throw new IllegalArgumentException("The account number contains incorrect dates.");
        }
    }
}
