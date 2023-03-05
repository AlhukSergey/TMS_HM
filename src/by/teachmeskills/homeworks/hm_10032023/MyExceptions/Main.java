package by.teachmeskills.homeworks.hm_10032023.MyExceptions;

import by.teachmeskills.homeworks.hm_10032023.MyExceptions.exceptions.IgnitionException;

public class Main {
    public static void main(String[] args) {
        Car car = new Car("Volvo", 300, 35000);
        Car car2 = new Car("BMV", 220, 25700);
        Car car3 = new Car("Chevrolet", 200, 18000);
        Car[] cars = {car, car2, car3};

        for(Car myCar: cars) {
            try {
                myCar.startEngine();
            } catch (IgnitionException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
