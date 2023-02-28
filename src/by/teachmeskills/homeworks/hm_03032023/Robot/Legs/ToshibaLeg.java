package by.teachmeskills.homeworks.hm_03032023.Robot.Legs;

import by.teachmeskills.homeworks.hm_03032023.Robot.Manufacturers.Toshiba;

public class ToshibaLeg extends Toshiba implements ILeg {
    public ToshibaLeg(int price) {
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
    public void step() {
        System.out.println(NAME + " foot makes a step!");
    }
}
