package by.teachmeskills.homeworks.hm_14042023.functional_interfaces;

import java.util.Scanner;

public class ConsoleReader {
    private ConsoleReader() {
    }

    public static int readConsole() {
        System.out.println("If you want to see the reversed string, enter 1.");
        System.out.println("If you want to see the factorial of the number, enter 2.");
        System.out.println("Please, make your choice:");
        boolean flag = true;
        int userChoice = 0;
        try (Scanner sc = new Scanner(System.in)) {
            while (flag) {
                userChoice = Integer.parseInt(sc.next());
                if (userChoice < 1 || userChoice > 2) {
                    System.out.println("Invalid data entered. Enter 1 or 2, please..");
                } else {
                    flag = false;
                }
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return userChoice;
    }
}
