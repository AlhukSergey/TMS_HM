package by.teachmeskills.homeworks.hm_17032023.firstTask;

import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("src\\by\\teachmeskills\\homeworks\\hm_17032023\\firstTask\\original file.txt"));
             BufferedWriter bw = new BufferedWriter(new FileWriter("src\\by\\teachmeskills\\homeworks\\hm_17032023\\firstTask\\target file.txt"))) {
            String line;
            ArrayList<String> words = new ArrayList<>();
            while ((line = br.readLine()) != null) {
                words.add(line);
            }

            ArrayList<String> palindromes = findPalindromes(words);
            for(String item: palindromes){
                bw.write(item + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static ArrayList<String> findPalindromes(ArrayList<String> arrayList) {
        ArrayList<String> palindromes = new ArrayList<>();
        for(String item: arrayList) {
            if(item.equalsIgnoreCase(new StringBuilder(item).reverse().toString())){
                palindromes.add(item);
            }
        }
        return palindromes;
    }
}
