package org.example.ejercicio02.model;

public class StaticStack<T> implements Stack<T> {

    private static final int MAX = 10000;
    private final T[] array;
    private int count;

    public StaticStack() {
        array = (T[]) new Object[MAX];
        count = 0;
    }

    @Override
    public void push(T element) {
        if (count == MAX) {
            throw new RuntimeException("No se puede agregar el elemento porque la pila está llena");
        }

        array[count] = element;
        count++;
    }

    @Override
    public void pop() {
        if (isEmpty()) {
            throw new RuntimeException("No se puede desapilar de una pila vacía");
        }

        count--;
    }

    @Override
    public T getTop() {
        if (isEmpty()) {
            throw new RuntimeException("No se puede obtener el elemento de una pila vacía");
        }

        return array[count - 1];
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }

}
