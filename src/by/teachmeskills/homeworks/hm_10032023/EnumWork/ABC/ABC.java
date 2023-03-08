package by.teachmeskills.homeworks.hm_10032023.EnumWork.ABC;

public enum ABC {
    A,
    B,
    C,
    D,
    F,
    G,
    E;

    public static String getLetterPosition(String letter) {
        return "The position of letter \"" + letter + "\" in ABC is " + (ABC.valueOf(letter).ordinal() + 1) + ".";
    }
}