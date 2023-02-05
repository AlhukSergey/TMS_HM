package by.teachmeskills.homeworks.hm_10022023_extra;

import java.util.Arrays;

public class Uniq {
    public static void main(String[] args) {
        System.out.println(findUniq(new double[]{ 2, 2, 3, 4, 3, 3 }));
    }

    static double findUniq(double[] array) {
        Arrays.sort(array);
        double uniqNumber;
        for (double v : array) {
            int counter = 0;
            for (double value : array) {
                if (v == value) {
                    counter++;
                }
                if (counter > 1) {
                    break;
                }
            }
            if (counter == 1) {
                uniqNumber = v;
                return uniqNumber;
            }
        }
        return 0;
    }
}

/*There is an array with some numbers. All numbers are equal except for one. Try to find it!

Kata.findUniq(new double[]{ 1, 1, 1, 2, 1, 1 }); // => 2
Kata.findUniq(new double[]{ 0, 0, 0.55, 0, 0 }); // => 0.55
It’s guaranteed that array contains at least 3 numbers.

The tests contain some very huge arrays, so think about performance.
*/
