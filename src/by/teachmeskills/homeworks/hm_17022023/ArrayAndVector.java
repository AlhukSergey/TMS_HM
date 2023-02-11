package by.teachmeskills.homeworks.hm_17022023;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayAndVector {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the length of the array:");
        int arrayLength = sc.nextInt();

        if (arrayLength <= 0) {
            System.out.println("Incorrect length entered!");
        } else {
            double[] array = new double[arrayLength];

            fillArray(array);

            if (arrayLength == 1) {
                System.out.println("The result of multiplying numbers from minimum to maximum is :" + array[0] + ".");
                if (array[0] < 0) {
                    System.out.println("The sum of the negatives numbers is : " + array[0] + ".");
                } else {
                    System.out.println("The sum of the negatives numbers is : 0.");
                }
            }

            System.out.println(Arrays.toString(array));
            System.out.println(returnProduct(array));
            System.out.println(calculateSum(array));
        }
    }
    private static void fillArray(double[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = roundNumber(Math.random() * 41 - 20);
        }
    }

    private static double roundNumber(double num) {
        double scale = Math.pow(10, 3);
        return Math.ceil(num * scale) / scale;
    }

    private static String calculateSum(double[] array) {
        double sumNegativeNumbers = 0;
        for (Double num : array) {
            if (num < 0) {
                sumNegativeNumbers += num;
            }
        }
        return "The sum of the negatives numbers is : " + roundNumber(sumNegativeNumbers) + ".";
    }

    private static String returnProduct(double[] array) {
        Arrays.sort(array);
        double max = array[array.length - 1];
        double min = array[0];
        int maxIndex = 0;
        int minIndex = 0;

        for (int i = 1; i < array.length; i++) {
            if (min >= array[i]) {
                min = array[i];
                minIndex = i;
            }
            if (max < array[i]) {
                max = array[i];
                maxIndex = i;
            }
        }

        double result = 1;
        for (int i = minIndex; i <= maxIndex; i++) {
            result = result * array[i];
        }
        return "The result of multiplying numbers from minimum to maximum is :" + roundNumber(result) + ".";
    }
}

/*1.Если бы члены массивы инициализировались вручную, то мог бы быть случай, когда два элемента одинаковых.
        В таком случае понадобятся знать индексы последних принятых за максимум и минимум элементов, чтобы
        дважды не учитывать повторяющиеся элементы массива при вычислении произведения.
        Но в поём случае использовался рандом, поэтому элементы ни разу не повторяться? следовательно можно было
        просто просчитать произведение элеменов массива?*/
/*2. очень интересно, как в реальных проектах проще всего проверить введенное со строки на NaN*/