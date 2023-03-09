package by.teachmeskills.homeworks.hm_17032023.secondTask;

import java.io.*;
import java.util.ArrayList;

import static by.teachmeskills.homeworks.hm_17032023.secondTask.TextFormatter.*;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader bf = new BufferedReader(new FileReader("src\\by\\teachmeskills\\homeworks\\hm_17032023\\secondTask\\original file.txt"));
             BufferedWriter bw = new BufferedWriter(new FileWriter("src\\by\\teachmeskills\\homeworks\\hm_17032023\\secondTask\\target file.txt"))) {
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
            e.printStackTrace();
        }
    }
}
