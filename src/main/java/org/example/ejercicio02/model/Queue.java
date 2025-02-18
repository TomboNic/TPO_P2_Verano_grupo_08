package org.example.ejercicio02.model;

public interface Queue<T> {

    void enqueue(T element);
    void dequeue();
    T getFirst();
    boolean isEmpty();

}
