package org.example.ejercicio01.model;

public class StaticQueueOfStacks implements QueueOfStacks {

    private static final int MAX = 10000;

    private final Stack[] array;
    private int count;

    public StaticQueueOfStacks() {
        this.array = new Stack[MAX];
        this.count = 0;
    }

    @Override
    public Stack getFirst() {
        if (this.isEmpty()) {
            throw new RuntimeException("No se puede obtener el primero de una cola vacia");
        }
        return this.array[0];
    }

    @Override
    public boolean isEmpty() {
        return this.count == 0;
    }

    @Override
    public void add(Stack stack) {
        this.array[count] = stack;
        this.count++;
    }

    @Override
    public void remove() {
        if (this.isEmpty()) {
            throw new RuntimeException("No se puede desacolar de una cola vacia");
        }
        for (int i = 0; i < this.count - 1; i++) {
            this.array[i] = this.array[i + 1];
        }
        this.count--;
    }

}
