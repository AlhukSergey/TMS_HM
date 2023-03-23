package by.teachmeskills.homeworks.hm_31032023.docValidator;

import by.teachmeskills.homeworks.hm_31032023.docValidator.exceptions.EmptyFilesListException;

import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        ConsoleReader consoleReader = new ConsoleReader();
        NumbersExecutor numbersExecutor = new NumbersExecutor();
        ResultGenerator resultGenerator = new ResultGenerator();

        try {
            HashSet<String> numbers = numbersExecutor.executeNumbers(consoleReader.readConsole());
            resultGenerator.createResult(numbers);
        } catch (EmptyFilesListException e) {
            System.out.println(e.getMessage());
        }
    }
}
