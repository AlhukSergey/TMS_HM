package by.teachmeskills.homeworks.hm_10032023.MyExceptions;

import by.teachmeskills.homeworks.hm_10032023.MyExceptions.exceptions.IgnitionException;

import java.util.Random;

public class Car {
    private String brand;
    private double speed;
    private int price;
    private boolean isWorking = false;

    public Car(String brand, double speed, int price) {
        this.brand = brand;
        this.speed = speed;
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isWorking() {
        return isWorking;
    }

    public void setWorking(boolean working) {
        isWorking = working;
    }

    public void startEngine() throws IgnitionException {
        Random random = new Random();
        int randomInt = random.nextInt(21);
        if (randomInt % 2 == 0) {
            throw new IgnitionException("An error occurred during starting the engine of " + this.brand + ".");
        } else {
            this.isWorking = true;
            System.out.println("The engine of " + this.brand + " started!");
        }
    }
}
