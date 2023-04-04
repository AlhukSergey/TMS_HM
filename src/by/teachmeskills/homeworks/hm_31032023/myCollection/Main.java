package by.teachmeskills.homeworks.hm_31032023.myCollection;

public class Main {
    public static void main(String[] args) {
        MyCollection<Integer> array = new MyCollection<>();
        array.add(1);
        array.add(2);
        array.add(3);

        for (int i = 0; i < array.getSize(); i++) {
            System.out.println(array.get(i));
        }

        System.out.println(array.contains(1));

        System.out.println("__________________________");

        System.out.println(array.getSize());

        System.out.println("__________________________");

        array.remove(0);

        for (int i = 0; i < array.getSize(); i++) {
            System.out.println(array.get(i));
        }

        System.out.println(array.getSize());

        System.out.println("__________________________");

        array.removeAll();

        for (int i = 0; i < array.getSize(); i++) {
            System.out.println(array.get(i));
        }

        System.out.println(array.getSize());

        System.out.println("__________________________");

        MyCollection<String> array2 = new MyCollection<>(5);
        System.out.println(array2.getSize());
        array2.add("H");
        array2.add("e");
        array2.add("l");
        array2.add("l");
        array2.add("o");
        array2.add("!");
        System.out.println(array2.getSize());
    }
}
