package by.teachmeskills.homeworks.hm_17032023.firstTask;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    private static final String ORIGINAL_FILE = "D:\\Study\\TMS\\hm_17032023\\firstTask\\original file.txt";
    private static final String TARGET_FILE = "D:\\Study\\TMS\\hm_17032023\\firstTask\\target file.txt";

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader(ORIGINAL_FILE));
             BufferedWriter bw = new BufferedWriter(new FileWriter(TARGET_FILE))) {
            String line;
            ArrayList<String> words = new ArrayList<>();
            while ((line = br.readLine()) != null) {
                words.add(line);
            }

            ArrayList<String> palindromes = findPalindromes(words);
            for (String item : palindromes) {
                bw.write(item + "\n");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static ArrayList<String> findPalindromes(ArrayList<String> arrayList) {
        ArrayList<String> palindromes = new ArrayList<>();
        for (String item : arrayList) {
            if (item.equalsIgnoreCase(new StringBuilder(item).reverse().toString())) {
                palindromes.add(item);
            }
        }
        return palindromes;
    }
}
