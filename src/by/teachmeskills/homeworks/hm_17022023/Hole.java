package by.teachmeskills.homeworks.hm_17022023;

import java.util.Scanner;

public class Hole {
    public static void main(String[] args) {
        double width = 0;
        double height = 0;
        double radius = 0;
        Scanner sc = new Scanner(System.in);

        consoleInput(sc, width, height, radius);

        System.out.println(radius * 2 >= Math.max(width, height) ? "True!" : "False!");

        /*if(2 * radius >= Math.max(width, height)) {
            System.out.println("True!");
        } else {
            System.out.println("False!");
        }*/
    }

    private static void consoleInput(Scanner scanner, double width, double height, double radius) {
        System.out.println("Enter the width of the rectangle:");
        width = scanner.nextDouble();
        System.out.println("Enter the height of the rectangle:");
        height = scanner.nextDouble();
        System.out.println("Enter the radius:");
        radius = scanner.nextDouble();

        // Нужна еще проверка на то, что введено именно число?!

        if(width <= 0 || height <=0 || radius <= 0) {
            System.out.println("Incorrect data entered!");
            consoleInput(scanner, width, height, radius);
        }
    }
}
