package by.teachmeskills.homeworks.hm_14042023.functional_interfaces2;

public class HeavyBox<T extends Number> {
    private final T weight;

    public HeavyBox(T weight) {
        this.weight = weight;
    }

    public T getWeight() {
        return weight;
    }
}
