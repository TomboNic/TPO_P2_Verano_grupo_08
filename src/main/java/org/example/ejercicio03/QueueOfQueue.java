package org.example.ejercicio03;

public interface QueueOfQueue {
    void add(Queue q);
    boolean isEmpty();
    Queue getFirst();
    void remove();
    Queue flat();
    void reverseWithDepth();
    QueueOfQueue concatenate(DynamicQueueOfQueue qoq1, DynamicQueueOfQueue qoq2);
}

