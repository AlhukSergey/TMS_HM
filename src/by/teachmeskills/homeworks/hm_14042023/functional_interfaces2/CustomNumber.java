package by.teachmeskills.homeworks.hm_14042023.functional_interfaces2;

public class CustomNumber {
    private final double number;

    public <T extends Number> CustomNumber(T number) {
        this.number = number.doubleValue();
    }

    public double getNumber() {
        return number;
    }
}
