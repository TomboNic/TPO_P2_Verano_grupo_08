package org.example.ejercicio04;

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

    public boolean isSubset(b_SuperSet otherSet) {
        // Un conjunto vacío es subconjunto de cualquier conjunto
        if (otherSet.isEmpty()) {
            return true;
        }

        // Si el otro conjunto tiene más elementos, no puede ser subconjunto
        if (otherSet.count > this.count) {
            return false;
        }

        // Verificar que cada elemento del otro conjunto esté en este conjunto
        for (int i = 0; i < otherSet.count; i++) {
            boolean encontrado = false;
            for (int j = 0; j < this.count; j++) {
                if (otherSet.array[i] == this.array[j]) {
                    encontrado = true;
                    break;
                }
            }
            if (!encontrado) {
                return false;
            }
        }
        return true;
    }

    @Override
    public Set Complement(b_SuperSet otherSet) {
        Set thisCopy = copy(this);
        Set copy = copy(otherSet);
        Set complementSet = new b_SuperSet();

        if(this.isSubset(otherSet)){
            throw new RuntimeException("No se puede calcular el complemento de un conjunto que no es subconjunto");
        }

        while(!copy.isEmpty()) {
            int element = thisCopy.choose();
            if(!in(element, copy)) {
                complementSet.add(element);
            }
            copy.remove(element);
        }

        return complementSet;
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

    public static boolean in(int element, Set set) {
        Set copy = copy(set);
        while(!copy.isEmpty()) {
            int aux = copy.choose();
            if(aux == element) {
                return true;
            }
            copy.remove(aux);
        }
        return false;
    }

    public static Set copy(Set set) {
        Set copy = new b_SuperSet();
        Set aux = new b_SuperSet();

        while(!set.isEmpty()) {
            int element = set.choose();
            copy.add(element);
            aux.add(element);
            set.remove(element);
        }

        while(!aux.isEmpty()) {
            int element = aux.choose();
            set.add(element);
            aux.remove(element);
        }

        return copy;
    }


}
