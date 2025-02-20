package org.example.ejercicio02.model;

public interface QueueWithPriority<T, P> {

    void enqueue(T element, P priority);
    void dequeue();
    T getFirst();
    P getPriority();
    boolean isEmpty();

}
