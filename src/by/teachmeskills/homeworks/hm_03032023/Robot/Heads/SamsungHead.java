package by.teachmeskills.homeworks.hm_03032023.Robot.Heads;

public class SamsungHead implements IHead {
    private int price;
    private final String name = "Samsung";

    public SamsungHead() {
    }

    public SamsungHead(int price) {
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
        System.out.println("Samsung head is speaking!");
    }
}
