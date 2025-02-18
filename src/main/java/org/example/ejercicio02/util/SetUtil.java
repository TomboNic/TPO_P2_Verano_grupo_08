package org.example.ejercicio02.util;


import org.example.ejercicio02.model.Set;
import org.example.ejercicio02.model.StaticSet;

import java.util.Comparator;

public class SetUtil<T> {

    public static <T> Set<T> copy(Set<T> set, Comparator<T> comparator) {
        Set<T> copy = new StaticSet<>(comparator);
        Set<T> aux = new StaticSet<>(comparator);

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

    public static <T> void print(Set<T> set, Comparator<T> comparator) {
        Set<T> copy = copy(set, comparator);

        System.out.print("[ ");
        while (!copy.isEmpty()) {
            T element = copy.choose();
            System.out.print(element + " ");
            copy.remove(element);
        }
        System.out.println("]");
    }

}
