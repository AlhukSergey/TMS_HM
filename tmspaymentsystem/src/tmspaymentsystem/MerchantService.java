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

    public void addBankAccount(String merchantId, BankAccount bankAccount) throws MerchantNotFoundException {
        validAccountNumber(bankAccount.getAccountNumber());
        Merchant merchant = getMerchantById(merchantId);
        Optional<BankAccount> account = merchant.getBankAccounts().stream().filter(s -> s.getAccountNumber().equals(bankAccount.getAccountNumber())).findAny();
        if (account.isPresent()) {
            account.filter(s -> s.getStatus().equals(AccountStatus.DELETED)).ifPresent(s -> s.setStatus(AccountStatus.ACTIVE));
        } else {
            merchant.getBankAccounts().add(bankAccount);
            FileService.writeToFile(FilesPaths.ACCOUNTS_FILE, bankAccount.toString());
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

    public void updateBankAccount(String bankAccountId, String newAccountNumber, String merchantId) throws BankAccountNotFoundException, IllegalArgumentException, MerchantNotFoundException {
        validAccountNumber(newAccountNumber);
        Merchant merchant = getMerchantById(merchantId);
        List<BankAccount> accounts = merchant.getBankAccounts();
        Optional<BankAccount> account = accounts.stream().filter(s -> s.getAccountNumber().equals(bankAccountId)).findAny();
        if (account.isPresent()) {
            account.get().setAccountNumber(newAccountNumber);
            FileService.updateFile(FilesPaths.ACCOUNTS_FILE, accounts.stream().map(BankAccount::toString).toList());
        } else {
            throw new BankAccountNotFoundException("No such bank account found!");
        }
    }

    public void deleteBankAccount(String bankAccountId, String merchantId) throws BankAccountNotFoundException, MerchantNotFoundException {
        Merchant merchant = getMerchantById(merchantId);
        List<BankAccount> accounts = merchant.getBankAccounts();
        Optional<BankAccount> account = accounts.stream().filter(s -> s.getAccountNumber().equals(bankAccountId)).findAny();
        if (account.isPresent()) {
            accounts.remove(account.get());
            FileService.updateFile(FilesPaths.ACCOUNTS_FILE, accounts.stream().map(BankAccount::toString).toList());
        } else {
            throw new BankAccountNotFoundException("No such bank account found!");
        }
    }

    public void createMerchant(String merchantName) {
        Merchant merchant = new Merchant(merchantName);
        merchants.add(merchant);
        FileService.writeToFile(FilesPaths.MERCHANT_FILE, merchant.toString());
    }

    public List<Merchant> getMerchants() {
        return merchants;
    }

    public String showMerchant(String merchantId) throws MerchantNotFoundException {
        Merchant merchant = getMerchantById(merchantId);
        return merchant.toString();
    }

    private Merchant getMerchantById(String id) throws MerchantNotFoundException {
        return merchants.stream().filter(s -> s.getId().equals(id)).findAny().orElseThrow(() -> new MerchantNotFoundException("No such merchant found!"));
    }

    public void deleteMerchant(String id) throws MerchantNotFoundException {
        Optional<Merchant> merchant = merchants.stream().filter(s -> s.getId().equals(id)).findAny();
        if (merchant.isPresent()) {
            merchants.remove(merchant.get());
            FileService.updateFile(FilesPaths.MERCHANT_FILE, merchants.stream().map(Merchant::toString).toList());
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
