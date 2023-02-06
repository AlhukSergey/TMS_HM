package by.teachmeskills.homeworks.hm_10022023_extra;

public class Maskify {
    public static void main(String[] args) {
        System.out.println(maskify("Hello world!"));
    }
    private static String maskify(String str) {
        char[] charArray = str.toCharArray();
        for(int i = 0; i <= charArray.length - 5; i++) {
            charArray[i] = '#';
        }
        return new String(charArray);
    }
}

/*
    Usually when you buy something, you're asked whether your credit card number, phone number or answer to your most
    secret question is still correct. However, since someone could look over your shoulder, you don't want that shown
    on your screen. Instead, we mask it.
    Your task is to write a function maskify, which changes all but the last four characters into '#'.*/
