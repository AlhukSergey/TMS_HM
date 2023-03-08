package by.teachmeskills.homeworks.hm_10032023.StringWork;

public class StringUtils {
    private StringUtils() {
    }

    public static char getLastChar(String str) {
        return str.charAt(str.length() - 1);
    }

    public static boolean isEndWith(String mainString, String stringEnd) {
        return mainString.endsWith(stringEnd);
    }

    public static boolean isStartWith(String mainString, String stringStart) {
        return mainString.startsWith(stringStart);
    }

    public static boolean isContaining(String processedString, String substring) {
        return processedString.contains(substring);
    }

    public static String convertToUpperCase(String str) {
        return str.toUpperCase();
    }

    public static String convertToLowerCase(String str) {
        return str.toLowerCase();
    }

    public static StringBuilder calculateResult(String operand1, String sing, String operand2) {
        StringBuilder result = new StringBuilder()
                .append(operand1)
                .append(" ")
                .append(sing)
                .append(" ")
                .append(operand2)
                .append(" = ");
        switch (sing) {
            case "+" -> result.append(Integer.parseInt(operand1) + Integer.parseInt(operand2));
            case "-" -> result.append(Integer.parseInt(operand1) - Integer.parseInt(operand2));
            case "*" -> result.append(Integer.parseInt(operand1) * Integer.parseInt(operand2));
            case "/" -> result.append((double) Integer.parseInt(operand1) / Integer.parseInt(operand2));
        }
        return result;
    }

    public static StringBuilder calculateResult(int operand1, String sing, int operand2) {
        StringBuilder result = new StringBuilder()
                .append(operand1)
                .append(" ")
                .append(sing)
                .append(" ")
                .append(operand2)
                .append(" = ");
        switch (sing) {
            case "+" -> result.append(operand1 + operand2);
            case "-" -> result.append(operand1 - operand2);
            case "*" -> result.append(operand1 * operand2);
            case "/" -> result.append((double) (operand1 / operand2));
        }
        return result;
    }

    public static StringBuilder calculateResult(double operand1, String sing, double operand2) {
        StringBuilder result = new StringBuilder()
                .append(operand1)
                .append(" ")
                .append(sing)
                .append(" ")
                .append(operand2)
                .append(" = ");
        switch (sing) {
            case "+" -> result.append(operand1 + operand2);
            case "-" -> result.append(operand1 - operand2);
            case "*" -> result.append(operand1 * operand2);
            case "/" -> result.append(operand1 / operand2);
        }
        return result;
    }

    public static StringBuilder replaceSing(StringBuilder str) {
        int index = str.indexOf("=");
        return str.deleteCharAt(index).insert(index, "равно");
    }

    public static StringBuilder showMiddleLetters(String str1, String str2) {
        StringBuilder result = new StringBuilder();
        result.append(str1.charAt(str1.length() - 1)).append(str2.charAt(0));
        return result;
    }

    public static char[] showMiddleLettersInEvenStrings(String str1, String str2) {
        StringBuilder concatenatedString = new StringBuilder().append(str1).append(str2);
        int indexOfMiddle = concatenatedString.length() / 2 - 1;
        char[] buffer = new char[2];
        concatenatedString.getChars(indexOfMiddle, indexOfMiddle + 2, buffer, 0);
        return buffer;
    }

    public static StringBuilder showPalindromes(String str) {
        str = removePunctuations(str);
        StringBuilder palindromes = new StringBuilder();

        StringBuilder strReversed = new StringBuilder(str).reverse();

        String[] wordsFromStr = str.split(" ");
        String[] wordsFromStrReversed = strReversed.toString().split(" ");

        for (int i = 0, j = wordsFromStrReversed.length - 1; i < wordsFromStr.length; i++, j--) {
            if (wordsFromStr[i].equalsIgnoreCase(wordsFromStrReversed[j])) {
                palindromes.append(wordsFromStr[i]).append(" ");
            }
        }
        return palindromes;
    }

    public static void showStringWithoutSpace(String str) {
        str = removePunctuations(str);
        String[] words = str.split(" ");
        for (String word : words) {
            System.out.println(word);
        }
    }

    private static String removePunctuations(String source) {
        return source.replaceAll("\\p{IsPunctuation}", "");
    }
}
