package by.teachmeskills.homeworks.hm_31032023.docValidator;

import by.teachmeskills.homeworks.hm_31032023.docValidator.exceptions.EmptyFilesListException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;

public class NumbersExecutor {
    public HashSet<String> executeNumbers(List<String> filesPath) throws EmptyFilesListException {
        if (filesPath.isEmpty()) {
            throw new EmptyFilesListException("The list is empty.");
        } else {
            HashSet<String> numbers = new HashSet<>();
            for (String path : filesPath) {
                try (BufferedReader br = new BufferedReader(new FileReader(path))) {
                    String line;
                    while ((line = br.readLine()) != null) {
                        numbers.add(line);
                    }
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }
            return numbers;
        }
    }
}
