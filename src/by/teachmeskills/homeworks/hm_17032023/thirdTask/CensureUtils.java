package by.teachmeskills.homeworks.hm_17032023.thirdTask;

import java.util.ArrayList;

public class CensureUtils {
    private static ArrayList<String> prohibitedWordsStr = new ArrayList<>();
    private static int prohibitedWordsCounter;

    private CensureUtils() {
    }

    public static void showCensureInfo() {
        if (prohibitedWordsCounter == 0) {
            System.out.println("The text has successfully passed the censorship check");
        } else {
            System.out.println("The text has not been censured.");
            System.out.println("The number of sentences with prohibited words: " + prohibitedWordsCounter);
            for (String string : prohibitedWordsStr) {
                System.out.println(string);
            }
        }
    }

    public static void checkCensure(String str, ArrayList<String> prohibitedWords) {

        String[] words = removePunctuations(str).split(" ");

        for (String word : words) {
            for (String prohibitedWord : prohibitedWords) {
                if (word.equalsIgnoreCase(prohibitedWord)) {
                    prohibitedWordsStr.add(str);
                    prohibitedWordsCounter++;
                }
            }
        }
    }

    private static String removePunctuations(String source) {
        return source.replaceAll("\\p{IsPunctuation}", "");
    }
}
