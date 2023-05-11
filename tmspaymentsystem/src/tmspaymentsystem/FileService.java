package tmspaymentsystem;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class FileService {
    private FileService() {
    }

    public static void writeToFile(String filePath, String data) {
        try {
            Files.write(Paths.get(filePath), data.getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void updateFile(String filePath, List<String> data) {
        try {
            Files.write(Paths.get(filePath), data, StandardCharsets.UTF_8);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<String> readFile(String filePath) {
        List<String> allData = new ArrayList<>();
        try {
            allData = Files.lines(Path.of(filePath)).toList();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return allData;
    }
}
