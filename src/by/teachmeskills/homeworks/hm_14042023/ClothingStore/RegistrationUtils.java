package by.teachmeskills.homeworks.hm_14042023.ClothingStore;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class RegistrationUtils {
    private static final String USER_DATA_FILE = "D:\\Study\\TMS\\hm_14042023\\userDB.txt";

    private RegistrationUtils() {
    }

    private static Map<String, String> readUserDate() {
        Map<String, String> userData = new HashMap<>();
        System.out.println("Welcome to our clothing store!");
        System.out.println("To get the discount card of our store, please, enter some data about yourself.");

        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Please, enter your name (Ivanov Ivan):");
            userData.put("NAME", sc.nextLine());
            System.out.println("Your gender (male/female):");
            userData.put("GENDER", sc.nextLine());
            System.out.println("Your birthday (yyyy-mm-dd):");
            userData.put("BIRTHDAY", sc.nextLine());
            System.out.println("Your phone number (format +375(33/29/44)1112233):");
            userData.put("PHONE_NUMBER", sc.nextLine());
            System.out.println("Your email(yours@gmail.com)");
            userData.put("EMAIL", sc.nextLine());
        }
        return userData;
    }

    private static boolean validateDate(Map<String, String> userData) {
        //if all validations true, the method will return "true".
        //if any validation returns "false", the method will return "false".
        boolean result = true;

        // check all data for empty or null
        Predicate<String> isNotNull = Objects::nonNull;
        Predicate<String> isNotEmpty = line -> !line.isEmpty();
        Predicate<String> isNotNullAndEmpty = isNotNull.and(isNotEmpty);
        for (Map.Entry<String, String> item : userData.entrySet()) {
            isNotNullAndEmpty.test(item.getValue());
        }

        // check date format
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        try {
            dateFormat.parse(userData.get("BIRTHDAY"));
        } catch (ParseException e) {
            System.out.println(e.getMessage());
            result = false;
        }

        //check phone number
        if (!((userData.get("PHONE_NUMBER").contains("+37533") || userData.get("PHONE_NUMBER").contains("+37529") || userData.get("PHONE_NUMBER").contains("+37544"))
                && userData.get("PHONE_NUMBER").length() == 13)) {
            result = false;
        }
        return result;
    }

    public static void createUserFile() {
        Map<String, String> userData = readUserDate();
        if (validateDate(userData)) {
            try {
                Files.write(Paths.get(USER_DATA_FILE),
                        userData.entrySet().stream().map(x -> x.getKey() + ":" + x.getValue()).collect(Collectors.toList()),
                        StandardCharsets.UTF_8);
                System.out.println("User successful created!");
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        } else {
            System.out.println("Illegal data entered! You'll NEVER get our discount card!");
        }
    }
}
