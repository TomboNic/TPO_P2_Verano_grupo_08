package org.example.ejercicio02.model;

public class StaticQueue<T> implements Queue<T> {

    private static final int MAX = 10000;
    private final T[] array;
    private int count;

    public StaticQueue() {
        array = (T[]) new Object[MAX];
        count = 0;
    }

    @Override
    public void enqueue(T element) {
        if (count == MAX) {
            throw new RuntimeException("No se puede agregar el elemento porque la cola está llena");
        }

        array[count] = element;
        count++;
    }

    @Override
    public void dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("No se puede desacolar de una cola vacía");
        }

        for (int i = 0; i < count - 1; i++) {
            array[i] = array[i + 1];
        }

        count--;
    }

    @Override
    public T getFirst() {
        if (isEmpty()) {
            throw new RuntimeException("No se puede obtener el elemento de una cola vacía");
        }

        return array[0];
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }

}
