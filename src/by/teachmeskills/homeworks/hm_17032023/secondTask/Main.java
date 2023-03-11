package by.teachmeskills.homeworks.hm_17032023.secondTask;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

import static by.teachmeskills.homeworks.hm_17032023.secondTask.TextFormatter.*;

public class Main {
    private static final String ORIGINAL_FILE = "D:\\Study\\TMS\\hm_17032023\\secondTask\\original file.txt";
    private static final String TARGET_FILE = "D:\\Study\\TMS\\hm_17032023\\secondTask\\target file.txt";

    public static void main(String[] args) {
        try (BufferedReader bf = new BufferedReader(new FileReader(ORIGINAL_FILE));
             BufferedWriter bw = new BufferedWriter(new FileWriter(TARGET_FILE))) {
            ArrayList<String> strings = new ArrayList<>();
            String line;
            while ((line = bf.readLine()) != null) {
                strings.add(line);
            }

            for (String string : strings) {
                int wordsNumber = countWordsNumber(string);
                if (isPalindromes(string)) {
                    bw.write(string + "\n");
                } else if (wordsNumber >= 3 && wordsNumber <= 5) {
                    bw.write(string + "\n");
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
