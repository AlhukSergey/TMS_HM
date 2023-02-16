package by.teachmeskills.homeworks.hw_24022023;

public class NumbersSequence {
    public static void main(String[] args) {
        int a = -5;
        int b = 5;
        showSequence(a, b);
        System.out.println();

        int c = 5;
        int d = -5;
        showSequence(c, d);
        System.out.println();

        int e = 5;
        int f = 5;
        showSequence(e, f);
    }

    private static void showSequence(int a, int b) {
        if (a == b) {
            System.out.println(a);
        } else if (a < b) {
            System.out.println(a);
            a++;
            showSequence(a, b);
        } else {
            System.out.println(a);
            a--;
            showSequence(a, b);
        }
    }
}
