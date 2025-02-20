package org.example.ejercicio02.model;

import java.util.Random;

public class StaticSet<T> implements Set<T> {

    private static final int MAX = 10000;
    private final T[] array;
    private int count;
    private final Random random;

    public StaticSet() {
        array = (T[]) new Object[MAX];
        count = 0;
        random = new Random();
    }

    @Override
    public void add(T element) {
        for (int i = 0; i < count; i++) {
            if (array[i].equals(element)) {
                return;
            }
        }

        array[count] = element;
        count++;
    }

    @Override
    public void remove(T element) {
        for (int i = 0; i < count; i++) {
            if (array[i].equals(element)) {
                array[i] = array[count - 1];
                count--;
                return;
            }
        }
    }

    @Override
    public T choose() {
        if(this.isEmpty()) {
            throw new RuntimeException("No se puede elegir un elemento de un conjunto vacío");
        }

        if (count == 1) {
            return array[0];
        }

        int randomIndex = random.nextInt(count);
        return array[randomIndex];
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }

}
