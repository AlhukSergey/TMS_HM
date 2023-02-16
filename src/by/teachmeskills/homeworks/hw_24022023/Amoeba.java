package by.teachmeskills.homeworks.hw_24022023;

public class Amoeba {
    public static void main(String[] args) {
        int degree = 1;
        for (int i = 3; i <= 24; i += 3) {
            System.out.println("After " + i + " hours there will be " + (int) Math.pow(2, degree) + " amoebas.");
            degree++;
        }
    }
}
