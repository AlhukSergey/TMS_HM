package tmspaymentsystem;

import tmspaymentsystem.exceptions.BankAccountNotFoundException;
import tmspaymentsystem.exceptions.MerchantNotFoundException;
import tmspaymentsystem.exceptions.NoBankAccountsFoundException;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class MerchantService {
    private List<Merchant> merchants = new ArrayList<>();

    public BankAccount addBankAccount(String merchantId, BankAccount bankAccount) throws MerchantNotFoundException {
        validAccountNumber(bankAccount.getAccountNumber());
        Merchant merchant = getMerchantById(merchantId);
        Optional<BankAccount> account = merchant.getBankAccounts().stream().filter(s -> s.getAccountNumber().equals(bankAccount.getAccountNumber())).findAny();
        if (account.isPresent()) {
            account.filter(s -> s.getStatus().equals(AccountStatus.DELETED)).ifPresent(s -> s.setStatus(AccountStatus.ACTIVE));
            return account.get();
        } else {
            merchant.getBankAccounts().add(bankAccount);
            FileService.writeToFile(FilesPaths.ACCOUNTS_FILE, bankAccount.toString());
            return bankAccount;
        }
    }

    public List<BankAccount> getMerchantBankAccounts(String merchantId) throws NoBankAccountsFoundException, MerchantNotFoundException {
        Merchant merchant = getMerchantById(merchantId);
        if (merchant.getBankAccounts().isEmpty()) {
            throw new NoBankAccountsFoundException("This merchant has no any bank account yet.");
        } else {
            return merchant.getBankAccounts().stream().sorted(Comparator.comparing(BankAccount::getCreatedTime)).sorted(Comparator.comparing(BankAccount::getStatus)).toList();
        }
    }

    public BankAccount updateBankAccount(String bankAccountId, String newAccountNumber, String merchantId) throws BankAccountNotFoundException, IllegalArgumentException, MerchantNotFoundException {
        validAccountNumber(newAccountNumber);
        Merchant merchant = getMerchantById(merchantId);
        List<BankAccount> accounts = merchant.getBankAccounts();
        Optional<BankAccount> account = accounts.stream().filter(s -> s.getAccountNumber().equals(bankAccountId)).findAny();
        if (account.isPresent()) {
            account.get().setAccountNumber(newAccountNumber);
            FileService.updateFile(FilesPaths.ACCOUNTS_FILE, accounts.stream().map(BankAccount::toString).toList());
            return account.get();
        } else {
            throw new BankAccountNotFoundException("No such bank account found!");
        }
    }

    public boolean deleteBankAccount(String bankAccountId, String merchantId) throws BankAccountNotFoundException, MerchantNotFoundException {
        Merchant merchant = getMerchantById(merchantId);
        List<BankAccount> accounts = merchant.getBankAccounts();
        Optional<BankAccount> account = accounts.stream().filter(s -> s.getAccountNumber().equals(bankAccountId)).findAny();
        if (account.isPresent()) {
            accounts.remove(account.get());
            FileService.updateFile(FilesPaths.ACCOUNTS_FILE, accounts.stream().map(BankAccount::toString).toList());
            return true;
        } else {
            throw new BankAccountNotFoundException("No such bank account found!");
        }
    }

    public Merchant createMerchant(String merchantName) {
        Merchant merchant = new Merchant(merchantName);
        merchants.add(merchant);
        FileService.writeToFile(FilesPaths.MERCHANT_FILE, merchant.toString());
        return merchant;
    }

    public List<Merchant> getMerchants() {
        return merchants;
    }

    public String showMerchant(String merchantId) throws MerchantNotFoundException {
        Merchant merchant = getMerchantById(merchantId);
        return merchant.toString();
    }

    private Merchant getMerchantById(String id) throws MerchantNotFoundException {
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
            FileService.updateFile(FilesPaths.MERCHANT_FILE, merchants.stream().map(Merchant::toString).toList());
            return true;
        } else {
            throw new MerchantNotFoundException("No such merchant found!");
        }
    }

    public BankAccount createBankAccount(String merchantId, String accountNumber) {
        return new BankAccount(merchantId, accountNumber);
    }

    private void validAccountNumber(String bankAccount) throws IllegalArgumentException {
        if (!bankAccount.matches("[0-9]{8}")) {
            throw new IllegalArgumentException("The account number contains incorrect dates.");
        }
    }
}
