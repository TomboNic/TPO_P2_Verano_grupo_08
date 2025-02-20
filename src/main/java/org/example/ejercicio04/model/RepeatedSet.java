package org.example.ejercicio04.model;

public interface RepeatedSet {
    // Métodos adicionales específicos para conjuntos con repetición
    void add(int element, int quantity);
    void remove(int element, int quantity);
    int getCount(int element);

    boolean isEmpty();

    int choose();

    int getTotalElements();
    int getUniqueElements();

}

