package by.teachmeskills.homeworks.hm_17022023;

import java.util.Scanner;

public class DayOfTheWeek {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean flag = true;

        while (flag) {
            try {
                System.out.println("Enter the day of the week:");
                int dayNumber = Integer.parseInt(sc.next());

                if (dayNumber <= 0 || dayNumber > 10) {
                    System.out.println("Invalid number entered.");
                } else {
                    if (dayNumber > 7) {
                        dayNumber %= 7;
                    }
                    switch (dayNumber) {
                        case 1 -> System.out.println("Monday");
                        case 2 -> System.out.println("Tuesday");
                        case 3 -> System.out.println("Wednesday");
                        case 4 -> System.out.println("Thursday");
                        case 5 -> System.out.println("Friday");
                        case 6 -> System.out.println("Saturday");
                        case 7 -> System.out.println("Sunday");
                        default -> System.out.println("Invalid data entered.");
                    }
                }
                flag = false;
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid data entered. Enter a number from 1 to 10, please..");
            }
        }
    }
}
