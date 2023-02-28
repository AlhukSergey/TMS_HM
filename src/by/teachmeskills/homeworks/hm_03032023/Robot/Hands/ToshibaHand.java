package by.teachmeskills.homeworks.hm_03032023.Robot.Hands;

import by.teachmeskills.homeworks.hm_03032023.Robot.Manufacturers.Toshiba;

public class ToshibaHand extends Toshiba implements IHand {
    public ToshibaHand(int price) {
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

