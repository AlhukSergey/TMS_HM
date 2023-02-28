package by.teachmeskills.homeworks.hm_03032023.OOP.Calculator;

public class Run {
    public static void main(String[] args) {
        Calculator calculator = new Calculator(2, 3);

        System.out.println(calculator.calculateSum(calculator.getOperand1(), calculator.getOperand2()));
        System.out.println(calculator.calculateDifference(calculator.getOperand1(), calculator.getOperand2()));
        System.out.println(calculator.calculateProduct(calculator.getOperand1(), calculator.getOperand2()));
    }
}
