package by.teachmeskills.homeworks.hm_14042023.ClothingStore;

import by.teachmeskills.homeworks.hm_14042023.ClothingStore.exceptions.EmptyProductListException;

public class Main {
    private static final String USER_DATA_FILE = "D:\\Study\\TMS\\hm_14042023\\userDB.txt";

    public static void main(String[] args) {
        //store initialization
        Store clothingStore = new Store("Reiss");
        clothingStore.addProduct(new Product("Shirt", 12.35));
        clothingStore.addProduct(new Product("Hat", 7));
        clothingStore.addProduct(new Product("Pants", 40.5));
        clothingStore.addProduct(new Product("Shoes", 25.3));

        //give discount card and add user to DB
        RegistrationUtils.createUserFile();
        try {
            NotificationUtils.sendNotification(USER_DATA_FILE, clothingStore);
        } catch (EmptyProductListException e) {
            System.out.println(e.getMessage());
        }

    }
}
