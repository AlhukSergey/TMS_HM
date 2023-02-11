package by.teachmeskills.homeworks.hm_17022023;

import java.util.Scanner;

public class Array2D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array, n = : ");
        int n = sc.nextInt();

        int[][] array = new int[n][n];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = (int) Math.round(Math.random() * 11 - 5);
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] % 2 == 0) {
                    array[i][j] = 0;
                } else {
                    array[i][j] = 1;
                }
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }
}

/*Немного не понял условния: подразумевалось, что элементы массива будут вводиться из консоли, как и размеры массива,
и в зависимости от того, четные они или нет, инициализируем член массива как 1 либо 0, или же значение зависит
от ИНДЕКСА массива (тогда в каждой строчке будет 1 0 1 0 1 0, что будет отличаться от примера вывода в задаче)?
Пока заполнил массив рандомными значениями от -5 до 5, и уже в зависимости от полученого значения после инициализации
назначал "1" либо "0".*/


