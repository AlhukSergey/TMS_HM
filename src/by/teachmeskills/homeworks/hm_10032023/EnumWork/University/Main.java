package by.teachmeskills.homeworks.hm_10032023.EnumWork.University;

public class Main {
    public static void main(String[] args) {
        University university = new University("№666", 2424, "summer");
        University university1 = new University("№13", 2048, "winter");
        university.showInfo();
        university1.showInfo();
    }
}
