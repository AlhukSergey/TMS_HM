package by.teachmeskills.homeworks.hm_03032023.Robot.Heads;

import by.teachmeskills.homeworks.hm_03032023.Robot.Manufacturers.Toshiba;

public class ToshibaHead extends Toshiba implements IHead {
    public ToshibaHead(int price) {
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
    public void speak() {
        System.out.println(NAME + " head is speaking!");
    }
}
