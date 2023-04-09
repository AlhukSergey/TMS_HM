package by.teachmeskills.homeworks.hm_14042023.ClothingStore;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.function.Predicate;

public class RegistrationUtils {
    private static final String usersDB = "D:\\Study\\TMS\\hm_14042023\\userDB.txt";

    private RegistrationUtils() {
    }

    private static List<String> readUserDate() {
        List<String> userDate;
        System.out.println("Welcome to our clothing store!");
        System.out.println("To get the discount card of our store, please, enter some data about yourself.");
        System.out.println("Please, enter your name (Ivan), gender (male/female), birthday (yyyy-mm-dd), " +
                "phone number (format +375(33/29/44)1112233)), email(yours@gmail.com), separated by commas:");
        try (Scanner sc = new Scanner(System.in)) {
            userDate = Arrays.asList(sc.nextLine().split(","));
        }
        return userDate;
    }

    private static boolean validateDate(List<String> userData) {
        //if all validations true, the method will return "true".
        //if any validation returns "false", the method will return "false".
        boolean result = true;

        // check all data for empty or null
        Predicate<String> isNotNull = Objects::nonNull;
        Predicate<String> isNotEmpty = line -> !line.isEmpty();
        Predicate<String> isNotNullAndEmpty = isNotNull.and(isNotEmpty);
        userData.forEach(isNotNullAndEmpty::test);

        // check date format
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        try {
            dateFormat.parse(userData.get(2));
        } catch (ParseException e) {
            System.out.println(e.getMessage());
            result = false;
        }

        //check phone number
        if (!((userData.get(3).contains("+37533") || userData.get(3).contains("+37529") || userData.get(3).contains("+37544"))
                && userData.get(3).length() == 13)) {
            result = false;
        }
        return result;
    }

    public static void createUserFile() {
        List<String> userData = readUserDate();
        if (validateDate(userData)) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(usersDB))) {
                for (String date : userData) {
                    bw.write(date + "\n");
                }
                System.out.println("User successful created!");
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        } else {
            System.out.println("Illegal data entered! You'll NEVER get our discount card!");
        }
    }
}
