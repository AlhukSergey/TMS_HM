package by.teachmeskills.homeworks.hw_24022023.SixthTask;

import java.util.Random;
import java.util.Scanner;

public class Computer {
    private final String processorType;
    private final String ramAmount;
    private final String hardDiskCapacity;
    private boolean isWorking = false;

    public Computer(String processorType, String ramAmount, String hardDiskCapacity) {
        this.processorType = processorType;
        this.ramAmount = ramAmount;
        this.hardDiskCapacity = hardDiskCapacity;
    }

    public void showInfo() {
        System.out.println("The computer has the type of processor " + this.processorType +
                ", the amount of RAM: " + this.ramAmount +
                ", and hard disk capacity: " + this.hardDiskCapacity + "."
        );
    }

    public void turnOn() {
        Random random = new Random();

        System.out.println("To turn on the computer you have to enter 0 or 1.");
        int n = inputNumber();

        if (n == random.nextInt(2)) {
            this.isWorking = true;
            System.out.println("The computer is turned on and works! All right!!!");
        } else {
            System.out.println("The computer is broken.");
        }
    }

    public void turnOff() {
        if (this.isWorking) {
            Random random = new Random();

            System.out.println("To turn off the computer you have to enter 0 or 1.");
            int n = inputNumber();

            if (n == random.nextInt(2)) {
                isWorking = false;
                System.out.println("The computer is turning off... See you later;)");
            } else {
                System.out.println("During the shutdown of the computer, a critical error occurred and it broke .... " +
                        "We apologize :(");
            }
        } else {
            System.out.println("Your computer isn't working now. But you can turn it on;)");
        }
    }

    public int inputNumber() {
        Scanner sc = new Scanner(System.in);

        boolean flag = true;
        int num = -1;

        while (flag) {
            try {
                System.out.println("Please, enter 0 or 1:");
                num = Integer.parseInt(sc.next());
                if (num != 0 && num != 1) {
                    System.out.println("Invalid data entered. Enter 0 or 1, please..");
                    inputNumber();
                }
                flag = false;
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid data entered. Enter 0 or 1, please..");
            }
        }
        return num;
    }
}
