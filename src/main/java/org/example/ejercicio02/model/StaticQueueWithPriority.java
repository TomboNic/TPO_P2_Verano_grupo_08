package org.example.ejercicio02.model;

public class StaticQueueWithPriority<T, P extends Comparable<P>> implements QueueWithPriority<T, P> {

    private static final int MAX = 10000;
    private final Object[] elements;
    private final Object[] priorities;
    private int count;

    public StaticQueueWithPriority() {
        elements = new Object[MAX];
        priorities = new Object[MAX];
        count = 0;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void enqueue(T element, P priority) {
        if (count == MAX) {
            throw new RuntimeException("No se puede agregar el elemento porque la cola está llena");
        }

        if (isEmpty()) {
            elements[0] = element;
            priorities[0] = priority;
            count++;
            return;
        }

        if (((P)priorities[count - 1]).compareTo(priority) <= 0) {
            elements[count] = element;
            priorities[count] = priority;
            count++;
            return;
        }

        if (((P)priorities[0]).compareTo(priority) > 0) {
            for (int i = count - 1; i >= 0; i--) {
                elements[i + 1] = elements[i];
                priorities[i + 1] = priorities[i];
            }

            elements[0] = element;
            priorities[0] = priority;
            count++;
            return;
        }

        int index = findIndex(priority);
        if (index != -1) {
            int candidate = index;
            while (candidate < count && ((P)priorities[candidate]).compareTo(priority) == 0) {
                candidate++;
            }

            for (int i = count - 1; i >= candidate; i--) {
                elements[i + 1] = elements[i];
                priorities[i + 1] = priorities[i];
            }

            elements[candidate] = element;
            priorities[candidate] = priority;
            count++;
            return;
        }

        int candidate = 0;
        while (candidate < count && ((P)priorities[candidate]).compareTo(priority) <= 0) {
            candidate++;
        }

        for (int i = count - 1; i >= candidate; i--) {
            elements[i + 1] = elements[i];
            priorities[i + 1] = priorities[i];
        }

        elements[candidate] = element;
        priorities[candidate] = priority;
        count++;
    }

    @SuppressWarnings("unchecked")
    private int findIndex(P priority) {
        for(int i = 0; i < this.count; i++) {
            if(((P)priorities[i]).compareTo(priority) == 0) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("No se puede desacolar de una cola vacía");
        }

        for (int i = 0; i < count - 1; i++) {
            elements[i] = elements[i + 1];
            priorities[i] = priorities[i + 1];
        }

        count--;
    }

    @Override
    @SuppressWarnings("unchecked")
    public T getFirst() {
        if (isEmpty()) {
            throw new RuntimeException("No se puede obtener el elemento de una cola vacía");
        }

        return (T)elements[0];
    }

    @Override
    @SuppressWarnings("unchecked")
    public P getPriority() {
        if (isEmpty()) {
            throw new RuntimeException("No se puede obtener la prioridad de una cola vacía");
        }

        return (P)priorities[0];
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }
}