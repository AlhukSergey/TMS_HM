package by.teachmeskills.homeworks.hm_03032023.Transport.AirTransport;

import by.teachmeskills.homeworks.hm_03032023.Transport.CapacityChecker;

public class CivilTransport extends AirTransport implements CapacityChecker {
    protected int passengersNumber;
    protected boolean hasBusinessClass;

    public CivilTransport(int power, double maxSpeed, int weight, String brand, double wingspan, double minRunwayLength,
                          int passengersNumber, boolean hasBusinessClass) {
        super(power, maxSpeed, weight, brand, wingspan, minRunwayLength);
        this.passengersNumber = passengersNumber;
        this.hasBusinessClass = hasBusinessClass;
    }

    @Override
    public String toString() {
        return "CivilTransport{" +
                "hasBusinessClass=" + hasBusinessClass +
                ", wingspan=" + wingspan + " м" +
                ", minRunwayLength=" + minRunwayLength + " м" +
                ", power=" + power + " л.с." +
                ", power in kilowatts =" + convertToKilowatts() + " Кв" +
                ", maxSpeed=" + maxSpeed + " км/ч" +
                ", weight=" + weight + " кг" +
                ", brand='" + brand + '\'' +
                '}';
    }

    @Override
    public void checkCapacity(double capacity) {
        System.out.println(this.passengersNumber < capacity ? "You need the bigger airplane!" : "The airplane is swirling.");
    }
}
