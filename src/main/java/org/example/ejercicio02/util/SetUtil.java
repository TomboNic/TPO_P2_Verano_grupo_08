package org.example.ejercicio02.util;

import org.example.ejercicio2.model.Set;
import org.example.ejercicio2.model.StaticSet;

public class SetUtil<T> {

    public static <T> Set<T> copy(Set<T> set) {
        Set<T> copy = new StaticSet<>();
        Set<T> aux = new StaticSet<>();

        while(!set.isEmpty()) {
            T element = set.choose();
            copy.add(element);
            aux.add(element);
            set.remove(element);
        }

        while(!aux.isEmpty()) {
            T element = aux.choose();
            set.add(element);
            aux.remove(element);
        }

        return copy;
    }

    public static <T> void print(Set<T> set) {
        Set<T> copy = copy(set);

        System.out.print("[ ");
        while (!copy.isEmpty()) {
            T element = copy.choose();
            System.out.print(element + " ");
            copy.remove(element);
        }
        System.out.println("]");
    }

}
