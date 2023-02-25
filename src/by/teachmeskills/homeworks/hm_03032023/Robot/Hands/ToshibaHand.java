package by.teachmeskills.homeworks.hm_03032023.Robot.Hands;

public class ToshibaHand implements IHand {
    private int price;
    private final String name = "Toshiba";

    public ToshibaHand() {
    }

    public ToshibaHand(int price) {
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
        System.out.println("Toshiba hand goes up!");
    }
}
