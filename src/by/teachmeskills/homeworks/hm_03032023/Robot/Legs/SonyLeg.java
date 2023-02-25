package by.teachmeskills.homeworks.hm_03032023.Robot.Legs;

public class SonyLeg implements ILeg {
    private int price;
    private final String name = "Sony";

    public SonyLeg() {
    }

    public SonyLeg(int price) {
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
    public void step() {
        System.out.println("Sony foot makes a step!");
    }
}
