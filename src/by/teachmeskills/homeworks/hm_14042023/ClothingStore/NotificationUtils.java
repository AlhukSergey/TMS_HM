package by.teachmeskills.homeworks.hm_14042023.ClothingStore;

import by.teachmeskills.homeworks.hm_14042023.ClothingStore.exceptions.EmptyProductListException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class NotificationUtils {
    private NotificationUtils() {
    }

    public static void sendNotification(String filePath, Store store) throws EmptyProductListException {
        //read userDate
        Map<String, String> userData = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            String[] data;
            while ((line = br.readLine()) != null) {
                data = line.split(":");
                userData.put(data[0], data[1]);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        //check data
        LocalDate currentDate = LocalDate.now();
        LocalDate userBirthday = LocalDate.parse(userData.get("Birthday"));
        LocalDate thisYearUserBirthday = userBirthday.withYear(2023);
        LocalDate weekBeforeUserBirthday = thisYearUserBirthday.minusDays(7);
        LocalDate weekAfterUserBirthday = thisYearUserBirthday.plusDays(7);
        LocalDate dayBeforeDiscountFinished = thisYearUserBirthday.plusDays(6);

        //send notification
        /*if (currentDate.isEqual(weekBeforeUserBirthday)) {
            if (userData.get("Gender").toUpperCase().equalsIgnoreCase(Gender.MALE.toString())) {
                System.out.printf("Уважаемый %s, магазин %s в Ваш День рождения дарит Вам в скидку 15%% на следующие товары %s. " +
                                "Скидка действует с %4$td %4$tB %4$tY до %5$td %5$tB %5$tY. " +
                                "Будем рады видеть Вас в нашем магазин!",
                        userData.get("Name"), store.getName(), store.getProductsListAsString(), thisYearUserBirthday, weekAfterUserBirthday);
            } else {
                System.out.printf("Уважаемая %s, магазин %s в Ваш День рождения дарит Вам в скидку 15%% на следующие товары %s." +
                                " Скидка действует с %4$td %4$tB %4$tY до %5$td %5$tB %5$tY. " +
                                "Будем рады видеть Вас в нашем магазин!",
                        userData.get("Name"), store.getName(), store.getProductsListAsString(), thisYearUserBirthday, weekAfterUserBirthday);
            }
        } else if (currentDate.isEqual(thisYearUserBirthday)) {
            if (userData.get("Gender").toUpperCase().equalsIgnoreCase(Gender.MALE.toString())) {
                System.out.printf("Уважаемый %s, магазин %s поздравляет Вас с Днем рождения и дарит Вам в скидку 15%% на следующие товары %s. " +
                                "Скидка действует с %4$td %4$tB %4$tY до %5$td %5$tB %5$tY. " +
                                "Будем рады видеть Вас в нашем магазин!",
                        userData.get("Name"), store.getName(), store.getProductsListAsString(), thisYearUserBirthday, weekAfterUserBirthday);
            } else {
                System.out.printf("Уважаемая %s, магазин %s поздравляет Вас с Днем рождения и дарит Вам в скидку 15%% на следующие товары %s." +
                                " Скидка действует с %4$td %4$tB %4$tY до %5$td %5$tB %5$tY. " +
                                "Будем рады видеть Вас в нашем магазин!",
                        userData.get("Name"), store.getName(), store.getProductsListAsString(), thisYearUserBirthday, weekAfterUserBirthday);
            }
        } else if (currentDate.isEqual(dayBeforeDiscountFinished)) {
            if (userData.get("Gender").toUpperCase().equalsIgnoreCase(Gender.MALE.toString())) {
                System.out.printf("Уважаемый %s! Магазин %s напоминает Вам про скидку 15%% на следующие товары %s. " +
                                "Скидка действует с %4$td %4$tB %4$tY до %5$td %5$tB %5$tY. " +
                                "Будем рады видеть Вас в нашем магазин!",
                        userData.get("Name"), store.getName(), store.getProductsListAsString(), dayBeforeDiscountFinished, weekAfterUserBirthday);
            } else {
                System.out.printf("Уважаемая %s! Магазин %s напоминает Вам про скидку 15%% на следующие товары %s. " +
                                "Скидка действует с %4$td %4$tB %4$tY до %5$td %5$tB %5$tY. " +
                                "Будем рады видеть Вас в нашем магазин!",
                        userData.get("Name"), store.getName(), store.getProductsListAsString(), dayBeforeDiscountFinished, weekAfterUserBirthday);
            }
        }*/

        if (currentDate.isEqual(weekBeforeUserBirthday)) {
            switch (userData.get("Gender").toLowerCase()) {
                case "male" ->
                        System.out.printf("Уважаемый %s, магазин %s в Ваш День рождения дарит Вам в скидку 15%% на следующие товары %s. " +
                                        "Скидка действует с %4$td %4$tB %4$tY до %5$td %5$tB %5$tY. " +
                                        "Будем рады видеть Вас в нашем магазин!",
                                userData.get("Name"), store.getName(), store.getProductsListAsString(), thisYearUserBirthday, weekAfterUserBirthday);
                case "female" ->
                        System.out.printf("Уважаемая %s, магазин %s в Ваш День рождения дарит Вам в скидку 15%% на следующие товары %s." +
                                        " Скидка действует с %4$td %4$tB %4$tY до %5$td %5$tB %5$tY. " +
                                        "Будем рады видеть Вас в нашем магазин!",
                                userData.get("Name"), store.getName(), store.getProductsListAsString(), thisYearUserBirthday, weekAfterUserBirthday);
            }
        } else if (currentDate.isEqual(thisYearUserBirthday)) {
            switch (userData.get("Gender").toLowerCase()) {
                case "male" ->
                        System.out.printf("Уважаемый %s, магазин %s поздравляет Вас с Днем рождения и дарит Вам в скидку 15%% на следующие товары %s. " +
                                        "Скидка действует с %4$td %4$tB %4$tY до %5$td %5$tB %5$tY. " +
                                        "Будем рады видеть Вас в нашем магазин!",
                                userData.get("Name"), store.getName(), store.getProductsListAsString(), thisYearUserBirthday, weekAfterUserBirthday);
                case "female" ->
                        System.out.printf("Уважаемая %s, магазин %s поздравляет Вас с Днем рождения и дарит Вам в скидку 15%% на следующие товары %s." +
                                        " Скидка действует с %4$td %4$tB %4$tY до %5$td %5$tB %5$tY. " +
                                        "Будем рады видеть Вас в нашем магазин!",
                                userData.get("Name"), store.getName(), store.getProductsListAsString(), thisYearUserBirthday, weekAfterUserBirthday);
            }
        } else if (currentDate.isEqual(dayBeforeDiscountFinished)) {
            switch (userData.get("Gender").toLowerCase()) {
                case "male" ->
                        System.out.printf("Уважаемый %s! Магазин %s напоминает Вам про скидку 15%% на следующие товары %s. " +
                                        "Скидка действует с %4$td %4$tB %4$tY до %5$td %5$tB %5$tY. " +
                                        "Будем рады видеть Вас в нашем магазин!",
                                userData.get("Name"), store.getName(), store.getProductsListAsString(), dayBeforeDiscountFinished, weekAfterUserBirthday);
                case "female" ->
                        System.out.printf("Уважаемая %s! Магазин %s напоминает Вам про скидку 15%% на следующие товары %s. " +
                                        "Скидка действует с %4$td %4$tB %4$tY до %5$td %5$tB %5$tY. " +
                                        "Будем рады видеть Вас в нашем магазин!",
                                userData.get("Name"), store.getName(), store.getProductsListAsString(), dayBeforeDiscountFinished, weekAfterUserBirthday);
            }
        }
    }
}
