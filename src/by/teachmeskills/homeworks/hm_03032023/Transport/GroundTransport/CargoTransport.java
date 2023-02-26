package by.teachmeskills.homeworks.hm_03032023.Transport.GroundTransport;

import by.teachmeskills.homeworks.hm_03032023.Transport.CapacityChecker;
import by.teachmeskills.homeworks.hm_03032023.Transport.Converter;

public class CargoTransport extends GroundTransport implements Converter, CapacityChecker {
    protected double loadCapacity;

    public CargoTransport(int power, double maxSpeed, int weight, String brand, int wheelsNumber, double fuelConsumption,
                          double loadCapacity) {
        super(power, maxSpeed, weight, brand, wheelsNumber, fuelConsumption);
        this.loadCapacity = loadCapacity;
    }

    @Override
    public String toString() {
        return "CargoTransport{" +
                "loadCapacity=" + loadCapacity + " т" +
                ", wheelsNumber=" + wheelsNumber +
                ", fuelConsumption=" + fuelConsumption + " л/100 км" +
                ", power=" + power + " л.с." +
                ", power in kilowatts =" + convertToKilowatts() + " Кв" +
                ", maxSpeed=" + maxSpeed + " км/ч" +
                ", weight=" + weight + " кг" +
                ", brand='" + brand + '\'' +
                '}';
    }

    @Override
    public double convertToKilowatts() {
        return this.power * 0.74;
    }

    @Override
    public void checkCapacity(double capacity) {
        System.out.println(this.loadCapacity < capacity ? "You need the bigger track!" : "The truck is swirling.");
    }
}
