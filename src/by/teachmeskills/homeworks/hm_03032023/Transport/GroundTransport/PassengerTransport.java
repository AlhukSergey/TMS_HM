package by.teachmeskills.homeworks.hm_03032023.Transport.GroundTransport;

import java.util.Scanner;

public class PassengerTransport extends GroundTransport {
    private static double length;
    protected String bodyType;
    protected int passengersNumber;

    public PassengerTransport(int power, double maxSpeed, int weight, String brand, int wheelsNumber, double fuelConsumption,
                              String bodyType, int passengersNumber) {
        super(power, maxSpeed, weight, brand, wheelsNumber, fuelConsumption);
        this.bodyType = bodyType;
        this.passengersNumber = passengersNumber;
    }

    public void calculateLength() {
        Scanner sc = new Scanner(System.in);

        boolean flag = true;
        while (flag) {
            try {
                System.out.println("Please, enter the time: ");
                double time = Double.parseDouble(sc.next());
                length = time * this.maxSpeed;
                System.out.println("За время " + time + " ч, автомобиль " + this.brand + ", двигаясь с максимальной скоростью "
                        + this.maxSpeed + " км/ч проедет " + length + " км и израсходует "
                        + calculateConsumptionFuel() + " литров топлива.");
                flag = false;
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid data entered.");
            }
        }
    }

    private double calculateConsumptionFuel() {
        return length * this.fuelConsumption / 100;
    }

    @Override
    public String toString() {
        return "PassengerTransport{" +
                "bodyType='" + bodyType + '\'' +
                ", passengersNumber=" + passengersNumber +
                ", wheelsNumber=" + wheelsNumber +
                ", fuelConsumption=" + fuelConsumption + " л/100 км" +
                ", power=" + power + " л.с." +
                ", power in kilowatts =" + convertToKilowatts() + " Кв" +
                ", maxSpeed=" + maxSpeed + " км/ч" +
                ", weight=" + weight + " кг" +
                ", brand='" + brand + '\'' +
                '}';
    }
}
