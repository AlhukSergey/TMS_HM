package by.teachmeskills.homeworks.hm_03032023.Robot.Heads;

import by.teachmeskills.homeworks.hm_03032023.Robot.Manufacturers.Sony;

public class SonyHead extends Sony implements IHead {
    public SonyHead(int price) {
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
