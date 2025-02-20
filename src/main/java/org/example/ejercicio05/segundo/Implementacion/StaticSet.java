package org.example.ejercicio05.segundo.Implementacion;

import org.example.ejercicio05.segundo.Interfaces.Set;

import java.util.Arrays;
import java.util.Objects;
import java.util.Random;

public class StaticSet implements Set {

    private static final int MAX = 10000;

    private final int[] array;
    private int count;
    private final Random random;

    public StaticSet() {
        this.array = new int[MAX];
        this.count = 0;
        this.random = new Random();
    }

    @Override
    public void add(int a) {
        for(int i = 0; i < count; i++) {
            if(array[i] == a) {
                return;
            }
        }
        array[count] = a;
        count++;
    }

    @Override
    public void remove(int a) {
        for(int i = 0; i < count; i++) {
            if(array[i] == a) {
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
        if(this.isEmpty()) {
            throw new RuntimeException("No se puede elegir un elemento de un conjunto vacío");
        }
        if(this.count == 1) {
            return array[0];
        }
        int randomIndex = random.nextInt(count);
        return array[randomIndex];
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        StaticSet staticSet = (StaticSet) o;

        if(count != staticSet.count) {
            return false;
        }

        if(count == 0) {
            return true;
        }

        int[] aux = Arrays.copyOf(array, count);
        int[] aux2 = Arrays.copyOf(staticSet.array, staticSet.count);
        Arrays.sort(aux);
        Arrays.sort(aux2);

        return Objects.deepEquals(array, staticSet.array);
    }

    @Override
    public int hashCode() {
        int[] aux = Arrays.copyOf(array, count);
        return Objects.hash(Arrays.hashCode(aux));
    }
}
