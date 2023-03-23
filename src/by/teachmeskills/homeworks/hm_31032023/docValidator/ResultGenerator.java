package by.teachmeskills.homeworks.hm_31032023.docValidator;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;

public class ResultGenerator {
    private static final String RESULT_FILE = "D:\\Study\\TMS\\hm_31032023\\second task\\resultValidation.txt";

    public void createResult(HashSet<String> numbers) {
        DocValidator docValidator = new DocValidator();
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(RESULT_FILE))) {
            for (String number : numbers) {
                bw.write(docValidator.checkValid(number).toString() + "\n");
            }
            System.out.println("The result of validation is successful written to the file \"resultValidation.txt\"");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
