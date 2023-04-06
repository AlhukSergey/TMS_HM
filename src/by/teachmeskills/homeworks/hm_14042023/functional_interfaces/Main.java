package by.teachmeskills.homeworks.hm_14042023.functional_interfaces;

public class Main {
    public static void main(String[] args) {
        String str = "Hello, user!";
        int num = 10;

        OperationAble<String> operation1 = x -> new StringBuilder(x).reverse().toString();
        OperationAble<Integer> operation2 = x -> {
            int result = 1;
            while (x != 1) {
                result *= x;
                x--;
            }
            return result;
        };

        int userChoice = ConsoleReader.readConsole();

        switch (userChoice) {
            case 1 -> System.out.println(operation1.show(str));
            case 2 -> System.out.println(operation2.show(num));
        }
    }
}
