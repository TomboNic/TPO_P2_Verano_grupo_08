package org.example.ejercicio02.model;

public interface QueueWithPriority<T> {

    void enqueue(T element, T priority);
    void dequeue();
    T getFirst();
    T getPriority();
    boolean isEmpty();

}
