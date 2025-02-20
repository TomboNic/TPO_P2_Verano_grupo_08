package org.example.ejercicio04.model;

public interface RepeatedSet {

    void add(int element, int quantity);
    void remove(int element, int quantity);
    int getCount(int element);

    boolean isEmpty();

    int choose();

    int getTotalElements();
    int getUniqueElements();

}

