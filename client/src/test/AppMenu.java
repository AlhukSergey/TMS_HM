package test;

import tmspaymentsystem.MerchantService;
import tmspaymentsystem.exceptions.BankAccountNotFoundException;
import tmspaymentsystem.exceptions.MerchantNotFoundException;
import tmspaymentsystem.exceptions.NoBankAccountsFoundException;

import java.util.Scanner;

public class AppMenu {
    private AppMenu() {
    }

    public static void start(MerchantService merchantService) {
        System.out.println("Select an action:");
        System.out.println("1. Add a new account to the merchant.");
        System.out.println("2. Show all accounts of the merchant.");
        System.out.println("3. Update an account of the merchant.");
        System.out.println("4. Delete an account of the merchant.");
        System.out.println("5. Add a new merchant.");
        System.out.println("6. Show merchant info.");
        System.out.println("7. Delete a merchant.");
        System.out.println("8. Show all merchants in the system.");
        System.out.println("9. Exit.");
        System.out.println("Please, enter the number of the action:");

        try (Scanner sc = new Scanner(System.in)) {
            boolean flag = true;
            int userChoice = Integer.parseInt(sc.next());
            while (flag) {
                if (userChoice < 1 || userChoice > 9) {
                    System.out.println("You have to enter a number from 1 to 9. Select an action:");
                    userChoice = Integer.parseInt(sc.next());
                } else {
                    switch (userChoice) {
                        case 1 -> merchantService.addBankAccount(enterMerchantId(sc), merchantService.createBankAccount(enterMerchantId(sc), enterBankAccountNumber(sc)));
                        case 2 -> merchantService.getMerchantBankAccounts(enterMerchantId(sc)).forEach(System.out::println);
                        case 3 -> merchantService.updateBankAccount(enterBankAccountId(sc), enterNewBankAccountNumber(sc), enterMerchantId(sc));
                        case 4 -> merchantService.deleteBankAccount(enterBankAccountId(sc), enterMerchantId(sc));
                        case 5 -> merchantService.createMerchant(enterMerchantName(sc));
                        case 6 -> System.out.println(merchantService.showMerchant(enterMerchantId(sc)));
                        case 7 -> merchantService.deleteMerchant(enterMerchantId(sc));
                        case 8 -> merchantService.getMerchants().forEach(System.out::println);
                        case 9 -> System.out.println("Bye!");
                    }
                    flag = false;
                }
            }
        } catch (IllegalArgumentException | NoBankAccountsFoundException | BankAccountNotFoundException |
                 MerchantNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    private static String enterMerchantName(Scanner sc) {
        System.out.println("Enter a new merchant name:");
        return sc.next();
    }

    private static String enterMerchantId(Scanner sc) {
        System.out.println("Enter a merchant id:");
        return sc.next();
    }

    private static String enterBankAccountNumber(Scanner sc) {
        System.out.println("Enter a new account number:");
        return sc.next();
    }

    private static String enterBankAccountId(Scanner sc) {
        System.out.println("Enter a bank account id:");
        return sc.next();
    }

    private static String enterNewBankAccountNumber(Scanner sc) {
        System.out.println("Enter a new account number:");
        return sc.next();
    }
}
