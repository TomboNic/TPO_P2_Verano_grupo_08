package org.example.ejercicio04.util;

import org.example.ejercicio04.model.Set;
import org.example.ejercicio04.model.b_SuperSet;

import java.util.Random;

public class b_SuperSetUtil implements Set {

    private static final int MAX = 10000;

    private final int[] array;
    private int count;
    private final Random random;

    public b_SuperSetUtil() {
        this.array = new int[MAX];
        this.count = 0;
        this.random = new Random();
    }

    public boolean isSubset(b_SuperSetUtil otherSet) {
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
    public Set Complement(b_SuperSetUtil otherSet) {
        Set thisCopy = copy(this);
        Set copy = copy(otherSet);
        Set complementSet = new b_SuperSetUtil();

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
        Set copy = new b_SuperSetUtil();
        Set aux = new b_SuperSetUtil();

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
