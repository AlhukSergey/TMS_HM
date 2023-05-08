package by.teachmeskills.homeworks.hm_28042023.stax;

import java.nio.file.Files;
import java.nio.file.Paths;

public class StaxExample {
    private static final String XML_FILE_PATH = "C:\\Users\\Alshuk\\IdeaProjects\\TMS\\src\\by\\teachmeskills\\homeworks\\hm_28042023\\medical_institution.xml";

    public static void main(String[] args) {
        try (StAXStreamProcessor stAXStreamProcessor = new StAXStreamProcessor(Files.newInputStream(Paths.get(XML_FILE_PATH)))) {
            stAXStreamProcessor.startElement();
            stAXStreamProcessor.getEmployees().forEach(e -> System.out.printf("Employee name: %s, position: %s, department: %s, experience: %s\n",
                    e.getName(), e.getPosition(), e.getDepartment(), e.getExperience()));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
