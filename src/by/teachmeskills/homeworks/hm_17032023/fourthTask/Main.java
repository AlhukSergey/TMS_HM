package by.teachmeskills.homeworks.hm_17032023.fourthTask;

import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class Main {
    private static final String DB = "D:\\Study\\TMS\\hm_17032023\\fourthTask\\car.dat";

    public static void main(String[] args) {
        Car car = new Car("Volvo", 248.3, 13500);

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(DB));
             ObjectInputStream ois = new ObjectInputStream(new FileInputStream(DB))) {
            oos.writeObject(car);
            Car car1 = (Car) ois.readObject();

            System.out.println(car1.getBrand());
            System.out.println(car1.getSpeed());
            System.out.println(car1.getPrice());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
