package by.teachmeskills.homeworks.hm_31032023.docValidator;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

public class ResultGenerator {
    private ResultGenerator() {
    }

    private static final String RESULT_FILE = "D:\\Study\\TMS\\hm_31032023\\second task\\resultValidation.txt";

    public static void createResult(HashMap<String, String> resultsValidation) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(RESULT_FILE))) {
            for (HashMap.Entry<String, String> result : resultsValidation.entrySet()) {
                bw.write(result.getKey() + result.getValue() + "\n");
            }
            System.out.println("The result of validation is successful written to the file \"resultValidation.txt\"");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }


}
