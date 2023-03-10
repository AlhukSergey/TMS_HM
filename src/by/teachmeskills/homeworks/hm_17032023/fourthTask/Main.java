package by.teachmeskills.homeworks.hm_17032023.fourthTask;

import java.io.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Car car = new Car("Volvo", 248.3, 13500);

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("src\\by\\teachmeskills\\homeworks\\hm_17032023\\fourthTask\\car.dat"));
             ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src\\by\\teachmeskills\\homeworks\\hm_17032023\\fourthTask\\car.dat"))) {
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
