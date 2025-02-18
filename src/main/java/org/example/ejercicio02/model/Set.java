package org.example.ejercicio02.model;

public interface Set<T> {

    void add(T element);
    void remove(T element);
    T choose();
    boolean isEmpty();

}
