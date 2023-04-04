package by.teachmeskills.homeworks.hm_31032023.docValidator;

import java.util.HashMap;
import java.util.HashSet;

public class DocValidator {
    private DocValidator() {
    }

    public static HashMap<String, String> checkValid(HashSet<String> numbers) {
        HashMap<String, String> result = new HashMap<>();
        for (String number : numbers) {
            if (number.length() != 15) {
                result.put(number, " - invalid - the length of the doc number should be 15 symbols.");
            } else if (number.contains("_")) {
                result.put(number, " - invalid - incorrect name of the document, the doc num contains illegal symbols.");
            } else {
                result.put(number, " - valid.");
            }
        }
        return result;
    }
}
