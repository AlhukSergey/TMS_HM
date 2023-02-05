package by.teachmeskills.homeworks.hm_10022023_extra;

public class HighestAndLowest {
    public static void main(String[] args) {
        System.out.println(highAndLow("1 5 3 7 10 15 -14 -7 -11"));
    }
    static String highAndLow(String str) {
        String[] array = str.split(" ");
        int high = Integer.parseInt(array[0]);
        int low = Integer.parseInt(array[0]);
        for(int i = 1; i < array.length; i++) {
            if(high < Integer.parseInt(array[i])) {
                high = Integer.parseInt(array[i]);
            }
            if(low > Integer.parseInt(array[i])) {
                low = Integer.parseInt(array[i]);
            }
        }
        return "The higher number in string is " + high + ". The lower number in string is " + low + ".";
    }
}
