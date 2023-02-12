package by.teachmeskills.homeworks.hm_17022023;

import java.util.Scanner;

public class Hole {
    private static double width = 0;
    private static double height = 0;
    private static double radius = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean flag = true;

        while (flag) {
            try {
                consoleInput(sc);
                System.out.println(width + " " + height + " " + radius);
                System.out.println(radius * 2 >= Math.max(width, height) ?
                        "You can overlap your rectangle with the circle with the radius " + radius + "!":
                        "You can't overlap your rectangle with the circle with the radius " + radius + "!");
                flag = false;
            } catch (NumberFormatException e) {
                System.out.println("Incorrect data entered! Please, enter numbers.");
            }
        }
    }

    private static void consoleInput(Scanner scanner) {
        System.out.println("Enter the width of the rectangle:");
        width = Double.parseDouble(scanner.next());
        System.out.println("Enter the height of the rectangle:");
        height = Double.parseDouble(scanner.next());
        System.out.println("Enter the radius:");
        radius = Double.parseDouble(scanner.next());

        if(width <= 0 || height <=0 || radius <= 0) {
            System.out.println("Incorrect data entered!");
            consoleInput(scanner);
        }
    }
}
