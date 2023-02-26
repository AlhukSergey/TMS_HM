package by.teachmeskills.homeworks.hm_03032023.OOP.Bank;

public class BankCard {
    private static final String[] owners = {"Ivan", "Sergey", "Roman"};
    private final String id;
    private final String number;
    private final String type;
    private final String cardOwner;
    private final String validity;
    private final String cvv;

    public BankCard(String id, String number, String type, String cardOwner, String validity, String cvv) {
        this.id = id;
        this.number = number;
        this.type = type;
        this.cardOwner = cardOwner;
        this.validity = validity;
        this.cvv = cvv;
        System.out.println((new Validator().checkCVV() &&
                new Validator().checkOwner() &&
                new Validator().checkDigitsNumber() &&
                new Validator().checkValidity() &&
                new Validator().checkType()) ? "The card is valid." : "The card isn't valid.");
    }

    private class Validator {
        private boolean checkDigitsNumber() {
            return number.length() == 16;
        }

        private boolean checkType() {
            return (type.equals("MasterCard") || type.equals("Visa"));
        }

        private boolean checkOwner() {
            boolean flag = false;
            for (String owner : owners) {
                if (owner.equals(cardOwner)) {
                    flag = true;
                    break;
                }
            }
            return flag;
        }

        private boolean checkValidity() {
            return validity.equals("20.02");
        }

        private boolean checkCVV() {
            return cvv.equals("123");
        }
    }
}
