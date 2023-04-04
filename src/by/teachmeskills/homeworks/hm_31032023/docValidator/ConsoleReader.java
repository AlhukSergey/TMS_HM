package by.teachmeskills.homeworks.hm_31032023.docValidator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsoleReader {
    private ConsoleReader() {
    }

    public static List<String> readConsole() {
        List<String> list = new ArrayList<>();
        System.out.println("Please, enter the file path:");
        System.out.println("If you want to exit, please, enter \"0\".");

        boolean flag = true;
        String line;
        try (Scanner sc = new Scanner(System.in)) {
            while (flag) {
                line = sc.next();
                if (line.equals("0")) {
                    flag = false;
                } else {
                    list.add(line);
                }
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }
}
