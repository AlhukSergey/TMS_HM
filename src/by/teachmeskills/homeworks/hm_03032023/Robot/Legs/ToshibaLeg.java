package by.teachmeskills.homeworks.hm_03032023.Robot.Legs;

public class ToshibaLeg implements ILeg {
    private int price;
    private final String name = "Toshiba";

    public ToshibaLeg() {
    }

    public ToshibaLeg(int price) {
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
        System.out.println("Toshiba foot makes a step!");
    }
}
