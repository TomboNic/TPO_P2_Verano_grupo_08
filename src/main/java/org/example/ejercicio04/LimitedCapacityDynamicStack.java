package org.example.ejercicio04;
import org.example.ejercicio04.Node;

public class LimitedCapacityDynamicStack implements Stack {

    private static int capacity = 1;
    private Node top;

    public LimitedCapacityDynamicStack(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be greater than 0");
        }
        this.capacity = capacity;
        this.top = null;
    }

    @Override

    public int getTop() {
        if(this.isEmpty()) {
            throw new RuntimeException("Can't obtain top of an empty stack");
        }
        return (int) this.top.getValue();
    }

    @Override
    public boolean isEmpty() {
        return this.top == null;
    }

    @Override
    public void add(int a) {
        this.top = new Node(a, this.top);
    }

    @Override
    public void remove() {
        if(this.isEmpty()) {
            throw new RuntimeException("Can't remove from an empty stack");
        }
        this.top = this.top.getNext();
    }
}
