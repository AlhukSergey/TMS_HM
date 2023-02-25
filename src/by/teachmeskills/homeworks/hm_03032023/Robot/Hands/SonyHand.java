package by.teachmeskills.homeworks.hm_03032023.Robot.Hands;

public class SonyHand implements IHand {
    private int price;
    private final String name = "Sony";

    public SonyHand() {
    }

    public SonyHand(int price) {
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
        System.out.println("Sony hand goes up!");
    }
}
