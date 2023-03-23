package by.teachmeskills.homeworks.hm_31032023.docValidator;

public class DocValidator {
    public StringBuilder checkValid(String line) {
        StringBuilder result = new StringBuilder(line);
        if (line.length() != 15) {
            result.append(" - invalid - the length of the number isn't 15.");
        } else if (line.contains("_")) {
            result.append(" - invalid - incorrect name of the document, illegal character ‘_’. ");
        } else {
            result.append(" - valid.");
        }
        return result;
    }
}
