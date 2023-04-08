package by.teachmeskills.homeworks.hm_14042023.functional_interfaces2;

import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        //1
        Predicate<String> isNotNull = Objects::nonNull;
        System.out.println(isNotNull.test(null));
        System.out.println(isNotNull.test("Hello"));
        System.out.println("________________");

        //2
        Predicate<String> isNotEmpty = line -> !line.isEmpty();
        System.out.println(isNotEmpty.test(""));
        System.out.println(isNotEmpty.test("world"));
        System.out.println("________________");

        //3
        Predicate<String> isNotNullAndNotEmpty = isNotNull.and(isNotEmpty);
        System.out.println(isNotNullAndNotEmpty.test(null));
        System.out.println(isNotNullAndNotEmpty.test(""));
        System.out.println(isNotNullAndNotEmpty.test("!"));
        System.out.println("________________");

        //4
        HeavyBox<Integer> heavyBox = new HeavyBox<>(25);
        Consumer<HeavyBox<Integer>> takeBox = x -> System.out.printf("Отгрузили ящик с весом %d.\n", x.getWeight());
        Consumer<HeavyBox<Integer>> sendBox = x -> System.out.printf("Отправляем ящик с весом %d.\n", x.getWeight());
        takeBox.andThen(sendBox).accept(heavyBox);
        System.out.println("________________");

        //5
        Function<NumberForFI, String> numberEstimator = x -> {
            if (x.getNumber() < 0) {
                return "Отрицательное число.";
            } else if (x.getNumber() == 0) {
                return "Ноль.";
            } else {
                return "Положительное число.";
            }
        };
        NumberForFI numberForFI = new NumberForFI(-8.5F);
        System.out.println(numberEstimator.apply(numberForFI));
        System.out.println("________________");

        //6
        Supplier<Integer> supplier = () -> (int) (Math.random() * 11);
        System.out.println(supplier.get());
    }
}
