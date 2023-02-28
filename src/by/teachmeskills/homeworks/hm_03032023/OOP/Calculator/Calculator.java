package by.teachmeskills.homeworks.hm_03032023.OOP.Calculator;

public class Calculator {
    private double operand1;
    private double operand2;

    public Calculator(double operand1, double operand2) {
        this.operand1 = operand1;
        this.operand2 = operand2;
    }

    public double calculateSum(double operand1, double operand2) {
        return operand1 + operand2;
    }

    public double calculateDifference(double operand1, double operand2) {
        return operand1 - operand2;
    }

    public double calculateProduct(double operand1, double operand2) {
        return operand1 * operand2;
    }

    public double getOperand1() {
        return operand1;
    }

    public void setOperand1(double operand1) {
        this.operand1 = operand1;
    }

    public double getOperand2() {
        return operand2;
    }

    public void setOperand2(double operand2) {
        this.operand2 = operand2;
    }
}
