package by.teachmeskills.homeworks.hm_03032023.Robot.Hands;

import by.teachmeskills.homeworks.hm_03032023.Robot.Manufacturers.Samsung;

public class SamsungHand extends Samsung implements IHand {
    public SamsungHand(int price) {
        super(price);
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public void upHand() {
        System.out.println(NAME + " hand goes up!");
    }
}
