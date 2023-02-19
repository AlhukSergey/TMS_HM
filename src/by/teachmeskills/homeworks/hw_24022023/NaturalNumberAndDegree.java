package by.teachmeskills.homeworks.hw_24022023;

public class NaturalNumberAndDegree {
    public static void main(String[] args) {
        int n = checkDegree(9);
        System.out.println(n == 1 ? "YES" : "NO");
    }

    private static int checkDegree(int n) {
        if (n % 2 == 1) {
            return n;
        }
        return checkDegree(n / 2);
    }
}
