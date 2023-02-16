package by.teachmeskills.homeworks.hw_24022023;

public class RunCycle {
    public static void main(String[] args) {
        double runningRatePerDay = 10;
        System.out.println(runLengthCalculate(runningRatePerDay, 7));
    }

    private static double runLengthCalculate(double runningRatePerDay, int daysAmount) {
        double distanceLength = 0;
        for (int i = 0; i < daysAmount; i++) {
            distanceLength += runningRatePerDay;
            runningRatePerDay = runningRatePerDay + runningRatePerDay * 0.1;
        }
        return distanceLength;
    }

}
