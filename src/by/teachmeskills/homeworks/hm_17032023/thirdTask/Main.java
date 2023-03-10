package by.teachmeskills.homeworks.hm_17032023.thirdTask;

import java.io.*;
import java.util.ArrayList;

import static by.teachmeskills.homeworks.hm_17032023.thirdTask.CensureUtils.*;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("src\\by\\teachmeskills\\homeworks\\hm_17032023\\thirdTask\\text for check.txt"));
             BufferedReader br1 = new BufferedReader(new FileReader("src\\by\\teachmeskills\\homeworks\\hm_17032023\\thirdTask\\black list.txt"))) {

            ArrayList<String> strings = new ArrayList<>();
            String lineForStringsArray;
            while ((lineForStringsArray = br.readLine()) != null) {
                strings.add(lineForStringsArray);
            }

            ArrayList<String> prohibitedWords = new ArrayList<>();
            String lineForProhibitedWordsArray;
            while ((lineForProhibitedWordsArray = br1.readLine()) != null) {
                prohibitedWords.add(lineForProhibitedWordsArray);
            }

            for (String string : strings) {
                checkCensure(string, prohibitedWords);
            }

            showInfoAboutCensure();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
