package by.teachmeskills.homeworks.hm_03032023.Robot.Heads;

public class SonyHead implements IHead {
    private int price;
    private final String name = "Sony";

    public SonyHead() {
    }

    public SonyHead(int price) {
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
        System.out.println("Sony head is speaking!");
    }
}
