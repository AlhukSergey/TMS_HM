package by.teachmeskills.homeworks.hm_03032023.Transport.GroundTransport;

import by.teachmeskills.homeworks.hm_03032023.Transport.Transport;

public abstract class GroundTransport extends Transport {
    protected int wheelsNumber;
    protected double fuelConsumption;

    public GroundTransport(int power, double maxSpeed, int weight, String brand, int wheelsNumber, double fuelConsumption) {
        super(power, maxSpeed, weight, brand);
        this.wheelsNumber = wheelsNumber;
        this.fuelConsumption = fuelConsumption;
    }
}
