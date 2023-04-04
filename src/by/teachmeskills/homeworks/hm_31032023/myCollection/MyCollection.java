package by.teachmeskills.homeworks.hm_31032023.myCollection;

import java.util.Arrays;

public class MyCollection<T> {
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] finalArray;
    private int size;

    public MyCollection() {
        finalArray = new Object[DEFAULT_CAPACITY];
    }

    public MyCollection(int userCapacity) {
        if (userCapacity > 0) {
            finalArray = new Object[userCapacity];
        } else if (userCapacity == 0) {
            finalArray = new Object[]{};
        } else {
            throw new IllegalArgumentException("Illegal data: " + userCapacity);
        }
    }

    public void add(T t) {
        add(finalArray, size, t);
    }

    private void add(Object[] array, int i, T el) {
        if (i == array.length) {
            array = increaseArraySize();
        }
        array[i] = el;
        size = i + 1;
    }

    private Object[] increaseArraySize() {
        return finalArray = Arrays.copyOf(finalArray, finalArray.length * 2);
    }

    public Object get(int i) {
        return finalArray[i];
    }

    public boolean contains(T el) {
        boolean result = false;
        for (Object o : finalArray) {
            if (o.equals(el)) {
                result = true;
                break;
            }
        }
        return result;
    }

    public void remove(int index) {
        for (int i = index; i < finalArray.length - 1; i++) {
            finalArray[i] = finalArray[i + 1];
        }
        finalArray[finalArray.length - 1] = null;
        size--;
    }

    public void removeAll() {
        Arrays.fill(finalArray, null);
        size = 0;
    }

    public int getSize() {
        return size;
    }
}
