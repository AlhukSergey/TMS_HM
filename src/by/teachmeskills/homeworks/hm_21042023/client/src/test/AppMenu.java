package test;

import tmspaymentsystem.BankAccount;
import tmspaymentsystem.Merchant;
import tmspaymentsystem.MerchantService;
import tmspaymentsystem.exceptions.BankAccountNotFoundException;
import tmspaymentsystem.exceptions.MerchantNotFoundException;
import tmspaymentsystem.exceptions.NoBankAccountsFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class AppMenu {
    private AppMenu() {
    }

    public static void start(MerchantService merchantService) {
        System.out.println("Select an action:");
        System.out.println("1. Add a new merchant account.");
        System.out.println("2. Show all merchant accounts.");
        System.out.println("3. Update a bank account.");
        System.out.println("4. Delete a bank account.");
        System.out.println("5. Create a new merchant.");
        System.out.println("6. Show merchant by merchant id.");
        System.out.println("7. Delete a merchant.");
        System.out.println("Please, enter the number of the action:");

        try (Scanner sc = new Scanner(System.in)) {
            boolean flag = true;
            int userChoice = Integer.parseInt(sc.next());
            while (flag) {
                if (userChoice < 1 || userChoice > 7) {
                    System.out.println("You have to enter a number from 1 to 7. Select an action:");
                    userChoice = Integer.parseInt(sc.next());
                } else {
                    switch (userChoice) {
                        case 1 ->
                                merchantService.addBankAccount(merchantService.getMerchantById(enterMerchantById(sc)), createBankAccount(sc));
                        case 2 ->
                                System.out.println(merchantService.getMerchantBankAccounts(merchantService.getMerchantById(enterMerchantById(sc))));
                        case 3 ->
                                merchantService.updateBankAccount(selectBankAccount(merchantService, sc), enterNewBankAccountNumber(sc));
                        case 4 -> merchantService.deleteBankAccount(selectBankAccount(merchantService, sc));
                        case 5 -> merchantService.createMerchant(createMerchant(sc));
                        case 6 -> merchantService.getMerchantById(enterMerchantById(sc));
                        case 7 -> merchantService.deleteMerchant(enterMerchantById(sc));
                    }
                    flag = false;
                }
            }
        } catch (IllegalArgumentException | NoBankAccountsFoundException | BankAccountNotFoundException |
                 MerchantNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    private static Merchant createMerchant(Scanner sc) {
        System.out.println("Enter a new merchant name;");
        return new Merchant(sc.next());
    }

    private static String enterMerchantById(Scanner sc) {
        System.out.println("Enter a merchant id:");
        return sc.next();
    }

    private static BankAccount createBankAccount(Scanner sc) {
        System.out.println("Enter a new merchant name:");
        System.out.println("Enter a merchant id:");
        int merchantId = Integer.parseInt(sc.next());
        System.out.println("Enter a new account number:");
        String accountNumber = sc.next();
        return new BankAccount(merchantId, accountNumber);
    }

    private static BankAccount selectBankAccount(MerchantService merchantService, Scanner sc) throws BankAccountNotFoundException {
        System.out.println("Enter an account number:");
        String accountNumber = sc.next();
        List<BankAccount> allBankAccounts = new ArrayList<>();
        merchantService.getMerchants().stream().map(Merchant::getBankAccounts).forEach(allBankAccounts::addAll);
        Optional<BankAccount> bankAccount = allBankAccounts.stream().filter(s -> s.getAccountNumber().equals(accountNumber)).findAny();
        if (bankAccount.isPresent()) {
            return bankAccount.get();
        } else {
            throw new BankAccountNotFoundException("No such bank account found!");
        }
    }

    private static String enterNewBankAccountNumber(Scanner sc) {
        System.out.println("Enter a new account number:");
        return sc.next();
    }
}
