package by.teachmeskills.homeworks.hm_17032023.thirdTask;

import java.util.ArrayList;

public class CensureUtils {
    private static ArrayList<String> stringsWithProhibitedWords = new ArrayList<>();
    private static int stringsWithProhibitedWordsCounter;

    private CensureUtils() {
    }

    public static void showInfoAboutCensure() {
        if (stringsWithProhibitedWordsCounter == 0) {
            System.out.println("The text has successfully passed the censorship check");
        } else {
            System.out.println("The text has not been censured.");
            System.out.println("The number of sentences with prohibited words: " + stringsWithProhibitedWordsCounter);
            for (String string : stringsWithProhibitedWords) {
                System.out.println(string);
            }
        }
    }

    public static void checkCensure(String str, ArrayList<String> prohibitedWords) {

        String[] words = removePunctuations(str).split(" ");

        for (String word : words) {
            for (String prohibitedWord : prohibitedWords) {
                if (word.equalsIgnoreCase(prohibitedWord)) {
                    stringsWithProhibitedWords.add(str);
                    stringsWithProhibitedWordsCounter++;
                }
            }
        }
    }

    private static String removePunctuations(String source) {
        return source.replaceAll("\\p{IsPunctuation}", "");
    }
}
