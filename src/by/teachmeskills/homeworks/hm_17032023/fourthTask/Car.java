package by.teachmeskills.homeworks.hm_17032023.fourthTask;

import java.io.Serializable;

public class Car implements Serializable {
    private String brand;
    private double speed;
    private int price;

    public Car(String brand, double speed, int price) {
        this.brand = brand;
        this.speed = speed;
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public double getSpeed() {
        return speed;
    }

    public int getPrice() {
        return price;
    }
}
