package by.teachmeskills.homeworks.hm_17022023;

import java.util.Random;

public class JaggedArray {
    public static void main(String[] args) {
        final Random randomLength = new Random();
        final Random randomNumberInArray = new Random();

        int[][] array = new int[2][];

        array[0] = new int[randomLength.nextInt(100)];
        array[1] = new int[randomLength.nextInt(100)];

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = randomNumberInArray.nextInt();
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }
}
