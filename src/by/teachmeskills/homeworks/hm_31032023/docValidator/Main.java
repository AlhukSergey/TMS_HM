package by.teachmeskills.homeworks.hm_31032023.docValidator;

import by.teachmeskills.homeworks.hm_31032023.docValidator.exceptions.EmptyFilesListException;

public class Main {
    public static void main(String[] args) {
        try {
            ResultGenerator.createResult(DocValidator.checkValid(NumbersExecutor.executeNumbers(ConsoleReader.readConsole())));
        } catch (EmptyFilesListException e) {
            System.out.println(e.getMessage());
        }

    }
}
