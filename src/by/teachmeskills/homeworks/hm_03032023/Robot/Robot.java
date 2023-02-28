package by.teachmeskills.homeworks.hm_03032023.Robot;

import by.teachmeskills.homeworks.hm_03032023.Robot.Hands.IHand;
import by.teachmeskills.homeworks.hm_03032023.Robot.Heads.IHead;
import by.teachmeskills.homeworks.hm_03032023.Robot.Legs.ILeg;

public class Robot implements IRobot {
    private IHead head;
    private IHand hand;
    private ILeg leg;

    public Robot() {
    }

    public Robot(IHead head, IHand hand, ILeg leg) {
        this.head = head;
        this.hand = hand;
        this.leg = leg;
    }

    @Override
    public int getPrice() {
        return head.getPrice() + hand.getPrice() + leg.getPrice();
    }

    @Override
    public void action() {
        head.speak();
        hand.upHand();
        leg.step();
    }

    public IHead getHead() {
        return head;
    }

    public void setHead(IHead head) {
        this.head = head;
    }

    public IHand getHand() {
        return hand;
    }

    public void setHand(IHand hand) {
        this.hand = hand;
    }

    public ILeg getLeg() {
        return leg;
    }

    public void setLeg(ILeg leg) {
        this.leg = leg;
    }

    @Override
    public String toString() {
        return "Robot{" +
                "head=" + head.getName() +
                ", hand=" + hand.getName() +
                ", leg=" + leg.getName() +
                '}';
    }
}
