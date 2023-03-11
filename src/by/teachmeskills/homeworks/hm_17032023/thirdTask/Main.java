package by.teachmeskills.homeworks.hm_17032023.thirdTask;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import static by.teachmeskills.homeworks.hm_17032023.thirdTask.CensureUtils.*;

public class Main {
    private static final String TEXT = "D:\\Study\\TMS\\hm_17032023\\thirdTask\\text for check.txt";
    private static final String BLACK_lIST = "D:\\Study\\TMS\\hm_17032023\\thirdTask\\black list.txt";

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader(TEXT));
             BufferedReader br1 = new BufferedReader(new FileReader(BLACK_lIST))) {

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

            showCensureInfo();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
