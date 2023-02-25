package by.teachmeskills.homeworks.hm_03032023.Robot.Hands;

public class SamsungHand implements IHand {
    private int price;
    private final String name = "Samsung";

    public SamsungHand() {
    }

    public SamsungHand(int price) {
        this.price = price;
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void upHand() {
        System.out.println("Samsung hand goes up!");
    }
}
