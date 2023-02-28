package by.teachmeskills.homeworks.hm_03032023.Transport.AirTransport;

import by.teachmeskills.homeworks.hm_03032023.Transport.Transport;

public abstract class AirTransport extends Transport {
    protected double wingspan;
    protected double minRunwayLength;

    public AirTransport(int power, double maxSpeed, int weight, String brand, double wingspan, double minRunwayLength) {
        super(power, maxSpeed, weight, brand);
        this.wingspan = wingspan;
        this.minRunwayLength = minRunwayLength;
    }
}
