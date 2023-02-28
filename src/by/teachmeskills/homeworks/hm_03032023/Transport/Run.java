package by.teachmeskills.homeworks.hm_03032023.Transport;

import by.teachmeskills.homeworks.hm_03032023.Transport.AirTransport.CivilTransport;
import by.teachmeskills.homeworks.hm_03032023.Transport.AirTransport.MilitaryTransport;
import by.teachmeskills.homeworks.hm_03032023.Transport.GroundTransport.CargoTransport;
import by.teachmeskills.homeworks.hm_03032023.Transport.GroundTransport.PassengerTransport;

public class Run {
    public static void main(String[] args) {
        CivilTransport airplane = new CivilTransport(10000, 1000, 750000, "Boeing-737",
                20, 25, 118, true);
        MilitaryTransport fighter = new MilitaryTransport(20000, 700, 900000, "SU-79",
                30, 50, true, 70);
        CargoTransport truck = new CargoTransport(300, 160, 5000, "Volvo", 16,
                25, 10);
        PassengerTransport car = new PassengerTransport(115, 220, 1800, "Dodge", 4,
                10, "Sedan", 5);

        Transport[] transports = {airplane, fighter, truck, car};
        for (Transport transport : transports) {
            System.out.println(transport.toString());
            System.out.println("------------------------------");
        }

        System.out.println("!-------------!");
        airplane.checkCapacity(200);
        fighter.fire();
        fighter.catapult();
        truck.checkCapacity(9000);
        car.calculateLength();
    }
}
