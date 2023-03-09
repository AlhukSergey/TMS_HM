package by.teachmeskills.homeworks.hm_17032023.secondTask;

public class TextFormatter {
    private TextFormatter() {
    }

    public static int countWordsNumber(String str) {
        String newStr = removePunctuations(str);
        String[] words = newStr.split(" ");
        return words.length;
    }

    public static boolean isPalindromes(String str) {
        String newStr = removePunctuations(str);
        String[] words = newStr.split(" ");
        boolean result = false;
        for (String word : words) {
            if (word.length() != 1 && word.equalsIgnoreCase(new StringBuilder(word).reverse().toString())) {
                result = true;
                break;
            }
        }
        return result;
    }

    private static String removePunctuations(String source) {
        return source.replaceAll("\\p{IsPunctuation}", "");
    }
}
