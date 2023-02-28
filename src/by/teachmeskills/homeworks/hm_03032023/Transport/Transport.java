package by.teachmeskills.homeworks.hm_03032023.Transport;

public abstract class Transport {
    protected int power;
    protected double maxSpeed;
    protected int weight;
    protected String brand;

    public Transport(int power, double maxSpeed, int weight, String brand) {
        this.power = power;
        this.maxSpeed = maxSpeed;
        this.weight = weight;
        this.brand = brand;
    }

    protected double convertToKilowatts() {
        return power * 0.74;
    }
}
