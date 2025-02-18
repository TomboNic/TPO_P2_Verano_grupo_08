package org.example.ejercicio02.model;
import java.util.Comparator;

public class StaticQueueWithPriority<T> implements QueueWithPriority<T> {

    private static final int MAX = 10000;
    private final T[] elements;
    private final T[] priorities;
    private final Comparator<T> comparator;
    private int count;

    public StaticQueueWithPriority(Comparator<T> comparator) {
        elements = (T[]) new Object[MAX];
        priorities = (T[]) new Object[MAX];
        this.comparator = comparator;
        count = 0;
    }

    @Override
    public void enqueue(T element, T priority) {
        if (count == MAX) {
            throw new RuntimeException("No se puede agregar el elemento porque la cola está llena");
        }

        if (isEmpty()) {
            elements[0] = element;
            priorities[0] = priority;
            count++;
            return;
        }

        if (comparator.compare(priorities[count - 1], priority) <= 0) {
            elements[count] = element;
            priorities[count] = priority;
            count++;
            return;
        }

        if (comparator.compare(priorities[0], priority) > 0) {
            for (int i = count - 1; i > 0; i--) {
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
            while (candidate < count && comparator.compare(priorities[candidate], priority) == 0) {
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
        while (candidate < count && comparator.compare(priorities[candidate], priority) <= 0) {
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

    private int findIndex(T priority) {
        for(int i = 0; i < this.count; i++) {
            if(comparator.compare(priorities[i], priority) == 0) {
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
    public T getFirst() {
        if (isEmpty()) {
            throw new RuntimeException("No se puede obtener el elemento de una cola vacía");
        }

        return elements[0];
    }

    @Override
    public T getPriority() {
        if (isEmpty()) {
            throw new RuntimeException("No se puede obtener la prioridad de una cola vacía");
        }

        return priorities[0];
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }

}
