package by.teachmeskills.homeworks.hm_03032023.Robot.Legs;

public class SamsungLeg implements ILeg {
    private int price;
    private final String name = "Samsung";

    public SamsungLeg() {
    }

    public SamsungLeg(int price) {
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
        System.out.println("Samsung foot makes a step!");
    }
}
