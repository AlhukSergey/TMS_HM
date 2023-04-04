package by.teachmeskills.homeworks.hm_31032023.calculator;

public class CalculatorUtils {
    private CalculatorUtils() {
    }

    public static <T extends Number, V extends Number> Double sum(T a, V b) {
        return a.doubleValue() + b.doubleValue();
    }

    public static <T extends Number, V extends Number> Double sub(T a, V b) {
        return a.doubleValue() - b.doubleValue();
    }

    public static <T extends Number, V extends Number> Double multiply(T a, V b) {
        return a.doubleValue() * b.doubleValue();
    }

    public static <T extends Number, V extends Number> Double div(T a, V b) {
        return a.doubleValue() / b.doubleValue();
    }
}
