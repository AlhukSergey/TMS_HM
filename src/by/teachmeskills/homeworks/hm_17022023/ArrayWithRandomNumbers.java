package by.teachmeskills.homeworks.hm_17022023;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayWithRandomNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the length of the array:");
        int arrayLength = sc.nextInt();
        int[] array = new int[arrayLength];


        for (int i = 0; i < arrayLength; i++) {
            array[i] = (int) Math.round(Math.random() * 11 - 5);
        }

        System.out.println("Before sorting:");
        System.out.println(Arrays.toString(array));


        System.out.println("After sorting:");
        System.out.println(Arrays.toString(sort(array)));
    }

    private static int[] sort(int[] array) {
        boolean isSorted = false;
        int temp;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    isSorted = false;
                    temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                }
            }
        }
        return array;
    }
}
