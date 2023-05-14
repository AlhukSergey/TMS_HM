package by.teachmeskills.homeworks.hm_05052023;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        Shop shop = new Shop("Jewelry",30);
        for (int i = 1; i < 20; i++) {
            shop.enter(new Buyer("Buyer" + i));
        }
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            executorService.submit(shop);
        }
        executorService.shutdown();
    }
}
