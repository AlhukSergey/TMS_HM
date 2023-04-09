package by.teachmeskills.homeworks.hm_14042023.ClothingStore;

import by.teachmeskills.homeworks.hm_14042023.ClothingStore.exceptions.EmptyProductListException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class NotificationUtils {
    private NotificationUtils() {
    }

    public static void sendNotification(String filePath, Store store) throws EmptyProductListException {
        //read userDate
        List<String> userData = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                userData.add(line);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        //check data
        LocalDate currentDate = LocalDate.now();
        LocalDate userBirthday = LocalDate.parse(userData.get(2));
        LocalDate userBirthdayForThisYear = userBirthday.withYear(2023);
        LocalDate minus7toUserBirthday = userBirthdayForThisYear.minusDays(7);
        LocalDate plus7toUserBirthday = userBirthdayForThisYear.plusDays(7);
        LocalDate plus6toUserBirthday = userBirthdayForThisYear.plusDays(6);

        //send notification
        if (currentDate.isEqual(minus7toUserBirthday)) {
            if (userData.get(1).equals("male")) {
                System.out.printf("Уважаемый %s, магазин %s в Ваш День рождения дарит Вам в скидку 15%% на следующие товары %s. " +
                                "Скидка действует с %4$td %4$tB %4$tY до %5$td %5$tB %5$tY. " +
                                "Будем рады видеть Вас в нашем магазин!",
                        userData.get(0), store.getName(), store.getProductsListAsString(), userBirthdayForThisYear, plus7toUserBirthday);
            } else {
                System.out.printf("Уважаемая %s, магазин %s в Ваш День рождения дарит Вам в скидку 15%% на следующие товары %s." +
                                " Скидка действует с %4$td %4$tB %4$tY до %5$td %5$tB %5$tY. " +
                                "Будем рады видеть Вас в нашем магазин!",
                        userData.get(0), store.getName(), store.getProductsListAsString(), userBirthdayForThisYear, plus7toUserBirthday);
            }
        } else if (currentDate.isEqual(userBirthdayForThisYear)) {
            if (userData.get(1).equals("male")) {
                System.out.printf("Уважаемый %s, магазин %s поздравляет Вас с Днем рождения и дарит Вам в скидку 15%% на следующие товары %s. " +
                                "Скидка действует с %4$td %4$tB %4$tY до %5$td %5$tB %5$tY. " +
                                "Будем рады видеть Вас в нашем магазин!",
                        userData.get(0), store.getName(), store.getProductsListAsString(), userBirthdayForThisYear, plus7toUserBirthday);
            } else {
                System.out.printf("Уважаемая %s, магазин %s поздравляет Вас с Днем рождения и дарит Вам в скидку 15%% на следующие товары %s." +
                                " Скидка действует с %4$td %4$tB %4$tY до %5$td %5$tB %5$tY. " +
                                "Будем рады видеть Вас в нашем магазин!",
                        userData.get(0), store.getName(), store.getProductsListAsString(), userBirthdayForThisYear, plus7toUserBirthday);
            }
        } else if (currentDate.isEqual(plus6toUserBirthday)) {
            if (userData.get(1).equals("male")) {
                System.out.printf("Уважаемый %s! Магазин %s напоминает Вам про скидку 15%% на следующие товары %s. " +
                                "Скидка действует с %4$td %4$tB %4$tY до %5$td %5$tB %5$tY. " +
                                "Будем рады видеть Вас в нашем магазин!",
                        userData.get(0), store.getName(), store.getProductsListAsString(), plus6toUserBirthday, plus7toUserBirthday);
            } else {
                System.out.printf("Уважаемая %s! Магазин %s напоминает Вам про скидку 15%% на следующие товары %s. " +
                                "Скидка действует с %4$td %4$tB %4$tY до %5$td %5$tB %5$tY. " +
                                "Будем рады видеть Вас в нашем магазин!",
                        userData.get(0), store.getName(), store.getProductsListAsString(), plus6toUserBirthday, plus7toUserBirthday);
            }
        }
    }
}
