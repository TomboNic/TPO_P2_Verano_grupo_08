package org.example.ejercicio04.model;

import java.util.Random;

public class b_SuperSet implements Set {

    private static final int MAX = 10000;

    private final int[] array;
    private int count;
    private final Random random;

    public b_SuperSet() {
        this.array = new int[MAX];
        this.count = 0;
        this.random = new Random();
    }


    @Override
    public void add(int a) {
        for (int i = 0; i < count; i++) {
            if (array[i] == a) {
                return;
            }
        }
        array[count] = a;
        count++;
    }

    @Override
    public void remove(int a) {
        for (int i = 0; i < count; i++) {
            if (array[i] == a) {
                array[i] = array[count - 1];
                count--;
                return;
            }
        }
    }

    @Override
    public boolean isEmpty() {
        return this.count == 0;
    }

    @Override
    public int choose() {
        if (this.isEmpty()) {
            throw new RuntimeException("No se puede elegir un elemento de un conjunto vacío");
        }
        if (this.count == 1) {
            return array[0];
        }
        int randomIndex = random.nextInt(count);
        return array[randomIndex];
    }
}
