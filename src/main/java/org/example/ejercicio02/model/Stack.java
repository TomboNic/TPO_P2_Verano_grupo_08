package org.example.ejercicio02.model;

public interface Stack<T> {

    void push(T element);
    void pop();
    T getTop();
    boolean isEmpty();

}
