package by.teachmeskills.homeworks.hm_03032023.Robot;

import by.teachmeskills.homeworks.hm_03032023.Robot.Hands.SamsungHand;
import by.teachmeskills.homeworks.hm_03032023.Robot.Hands.SonyHand;
import by.teachmeskills.homeworks.hm_03032023.Robot.Hands.ToshibaHand;
import by.teachmeskills.homeworks.hm_03032023.Robot.Heads.SamsungHead;
import by.teachmeskills.homeworks.hm_03032023.Robot.Heads.SonyHead;
import by.teachmeskills.homeworks.hm_03032023.Robot.Heads.ToshibaHead;
import by.teachmeskills.homeworks.hm_03032023.Robot.Legs.SamsungLeg;
import by.teachmeskills.homeworks.hm_03032023.Robot.Legs.SonyLeg;
import by.teachmeskills.homeworks.hm_03032023.Robot.Legs.ToshibaLeg;

public class Run {
    public static void main(String[] args) {
        Robot robot1 = new Robot(new SamsungHead(100), new SonyHand(200), new ToshibaLeg(300));
        Robot robot2 = new Robot(new SonyHead(400), new ToshibaHand(500), new SamsungLeg(600));
        Robot robot3 = new Robot(new ToshibaHead(700), new SamsungHand(800), new SonyLeg(900));

        Robot[] robots = {robot1, robot2, robot3};
        for (Robot robot : robots) {
            robot.action();
            System.out.println("-------------------");
        }

        System.out.println(findMostExpensive(robots));
    }

    private static String findMostExpensive(Robot[] robots) {
        Robot mostExpensiveRobot = robots[0];
        for (int i = 1; i < robots.length; i++) {
            if (robots[i].getPrice() >= robots[i - 1].getPrice()) {
                mostExpensiveRobot = robots[i];
            }
        }
        return "The most expensive robot is " + mostExpensiveRobot;
    }
}
