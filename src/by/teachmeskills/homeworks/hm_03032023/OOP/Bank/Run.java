package by.teachmeskills.homeworks.hm_03032023.OOP.Bank;

public class Run {
    public static void main(String[] args) {
        BankCard card = new BankCard("1234123412341234", "MasterCard", "Ivan", "20.02", "123");
        card.checkValid();
    }
}
