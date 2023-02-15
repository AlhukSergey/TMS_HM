package by.teachmeskills.homeworks.hm_17022023;

import java.util.Random;

public class JaggedArray {
    public static void main(String[] args) {
        final Random randomLinesNumber = new Random();
        final Random randomColumnsNumber = new Random();
        final Random randomNumberInArray = new Random();

        int[][] array = new int[randomLinesNumber.nextInt(10)][];


        for (int i = 0; i < array.length; i++) {
            array[i] = new int[randomColumnsNumber.nextInt(15)];
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = randomNumberInArray.nextInt(10);
                System.out.print(array[i][j]);
            }
            System.out.println();
        }
    }
}
