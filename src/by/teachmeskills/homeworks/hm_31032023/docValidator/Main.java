package by.teachmeskills.homeworks.hm_31032023.docValidator;

import by.teachmeskills.homeworks.hm_31032023.docValidator.exceptions.EmptyFilesListException;

public class Main {
    public static void main(String[] args) {
        ConsoleReader consoleReader = new ConsoleReader();
        NumbersExecutor numbersExecutor = new NumbersExecutor();
        DocValidator docValidator = new DocValidator();
        ResultGenerator resultGenerator = new ResultGenerator();

        try {
            resultGenerator.createResult(docValidator.checkValid(numbersExecutor.executeNumbers(consoleReader.readConsole())));
        } catch (EmptyFilesListException e) {
            System.out.println(e.getMessage());
        }

    }
}
