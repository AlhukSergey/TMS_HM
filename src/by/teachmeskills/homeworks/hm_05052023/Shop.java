package by.teachmeskills.homeworks.hm_05052023;

import java.util.concurrent.ArrayBlockingQueue;

public class Shop implements Runnable {
    private volatile int buyersNumber;
    private ArrayBlockingQueue<Buyer> buyers;
    private String name;

    public Shop(String name, int numberBuyersPerDay) {
        this.name = name;
        this.buyers = new ArrayBlockingQueue<>(numberBuyersPerDay);
    }

    public String getName() {
        return name;
    }

    public void enter(Buyer buyer) {
        buyers.add(buyer);
    }

    private synchronized void increment() {
        buyersNumber++;
        System.out.printf("The shop has %d clients\n", buyersNumber);
    }

    private synchronized void decrement() {
        buyersNumber--;
    }

    private void takeBreak() {
        System.out.printf("%s is closed! Come back in 10 minutes\n", name);
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private void service(Buyer buyer) {
        try {
            int serviceTime = (int) ((Math.random() * 8 + 1) * 1000);
            Thread.sleep(serviceTime);
            System.out.printf("The %s left the shop.\n", buyer.getName());
            System.out.printf("The shop %s serviced client %s in %d minutes\n", name, buyer.getName(), serviceTime / 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void run() {
        while (buyers.size() > 0) {
            increment();
            Buyer buyer = buyers.poll();
            System.out.printf("%s came in the shop.\n", buyer.getName());
            while (buyersNumber < 4) {
                //while buyersNumber < 4 the service of client won't start.
            }
            service(buyer);
            decrement();
            if (buyersNumber < 4) {
                System.out.printf("The shop has %d clients\n", buyersNumber);
                takeBreak();
            }
        }
    }
}
