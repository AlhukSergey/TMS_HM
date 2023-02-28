package by.teachmeskills.homeworks.hm_03032023.Transport.AirTransport;

public class MilitaryTransport extends AirTransport {
    protected boolean hasEjectionSystem;
    protected int missilesNumber;

    public MilitaryTransport(int power, double maxSpeed, int weight, String brand, double wingspan, double minRunwayLength,
                             boolean hasEjectionSystem, int missilesNumber) {
        super(power, maxSpeed, weight, brand, wingspan, minRunwayLength);
        this.hasEjectionSystem = hasEjectionSystem;
        this.missilesNumber = missilesNumber;
    }

    @Override
    public String toString() {
        return "MilitaryTransport{" +
                "hasEjectionSystem=" + hasEjectionSystem +
                ", missilesNumber=" + missilesNumber +
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
    public double convertToKilowatts() {
        return this.power * 0.74;
    }

    public void fire() {
        System.out.println(this.missilesNumber > 0 ? "The rocket flew!!!" : "No ammo...");
    }

    public void catapult() {
        System.out.println(this.hasEjectionSystem ? "The ejection was successful!!!" : "Tou don't have such system.");
    }
}
