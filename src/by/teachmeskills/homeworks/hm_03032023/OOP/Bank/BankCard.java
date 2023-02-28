package by.teachmeskills.homeworks.hm_03032023.OOP.Bank;

public class BankCard {
    private static final String[] owners = {"Ivan", "Sergey", "Roman"};
    private static int incID = 0;
    private final int ID;
    private final String NUMBER;
    private final String TYPE;
    private final String CARDOWNER;
    private final String VALIDITY;
    private final String CVV;

    public BankCard(String NUMBER, String TYPE, String CARDOWNER, String VALIDITY, String CVV) {
        this.ID = incID++;
        this.NUMBER = NUMBER;
        this.TYPE = TYPE;
        this.CARDOWNER = CARDOWNER;
        this.VALIDITY = VALIDITY;
        this.CVV = CVV;
    }

    public void checkValid() {
        class Validator {
            private boolean checkDigitsNumber() {
                return NUMBER.length() == 16;
            }

            private boolean checkType() {
                return (TYPE.equals("MasterCard") || TYPE.equals("Visa"));
            }

            private boolean checkOwner() {
                boolean flag = false;
                for (String owner : owners) {
                    if (owner.equals(CARDOWNER)) {
                        flag = true;
                        break;
                    }
                }
                return flag;
            }

            private boolean checkValidity() {
                return VALIDITY.equals("20.02");
            }

            private boolean checkCVV() {
                return CVV.equals("123");
            }
        }
        Validator validator = new Validator();
        System.out.println((validator.checkCVV() &&
                validator.checkOwner() &&
                validator.checkDigitsNumber() &&
                validator.checkValidity() &&
                validator.checkType()) ? "The card is valid." : "The card isn't valid.");
    }
}
