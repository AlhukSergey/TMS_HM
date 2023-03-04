package by.teachmeskills.homeworks.hm_10032023.StringWork;

import static by.teachmeskills.homeworks.hm_10032023.StringWork.StringUtils.*;

public class Main {
    public static void main(String[] args) {
        System.out.println(getLastChar("Hello"));
        System.out.println(isEndWith("I'm a human!!!", "!!!"));
        System.out.println(isStartWith("Сиреневенький синхрофазатрон - самый несложный предмет!", "Сиреневенький синхрофазатрон"));
        System.out.println(isContaining("Сиреневенький синхрофазатрон - самый несложный предмет!", "Сиреневенький синхрофазатрон"));
        System.out.println(isContaining("амый несложный предмет!", "Сиреневенький синхрофазатрон"));
        System.out.println(convertToUpperCase("Сиреневенький синхрофазатрон"));
        System.out.println(convertToLowerCase("Сиреневенький синхрофазатрон"));
        System.out.println(calculateResult("1", "+", "2"));
        System.out.println(calculateResult(2, "-", 5));
        System.out.println(calculateResult(2.7, "*", 2.33));
        System.out.println(replaceSing(new StringBuilder("1 + 2 = 3")));
        System.out.println(showMiddleLetters("Hello", "world"));
        System.out.println(showMiddleLettersInEvenStrings("blue", "hell"));
        System.out.println(showPalindromes("Око, зуб, арбуз, казак, победа"));
        showStringWithoutSpace("Цыган на цыпочках цыплёночка ловил и говорил ему цыц.");
    }
}
