package by.teachmeskills.homeworks.hm_17022023;

public class JaggedArray {
    public static void main(String[] args) {
        int[][] array = new int[2][];

        array[0] = new int[(int) Math.round(Math.random() * 10)];
        array[1] = new int[(int) Math.round(Math.random() * 10)];

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = (int) Math.round(Math.random() * 21 - 10);
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }
}
