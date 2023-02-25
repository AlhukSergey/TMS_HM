package by.teachmeskills.homeworks.hm_03032023.Robot.Heads;

public class ToshibaHead implements IHead {
    private int price;
    private final String name = "Toshiba";

    public ToshibaHead() {
    }

    public ToshibaHead(int price) {
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
    public void speak() {
        System.out.println("Toshiba head is speaking!");
    }
}
