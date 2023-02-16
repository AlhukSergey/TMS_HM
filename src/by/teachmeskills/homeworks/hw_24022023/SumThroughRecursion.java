package by.teachmeskills.homeworks.hw_24022023;

public class SumThroughRecursion {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(calculateSum(array, array.length));
    }
    private static int calculateSum(int[] arr, int arrayLength) {
        if (arrayLength == 0) {
            return 0;
        }
        int result = arr[arrayLength - 1];
        return result + calculateSum(arr, arrayLength - 1);
    }
}
