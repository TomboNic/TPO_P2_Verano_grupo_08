package org.example.ejercicio04;
import org.example.ejercicio04.Node;

public class LimitedCapacityDynamicStack implements Stack {

    public static int maxCapacity;
    public static int capacity = 1;
    private Node top;

    public LimitedCapacityDynamicStack(int maxCapacity) {
        if (maxCapacity <= 0) {
            throw new IllegalArgumentException("Capacity must be greater than 0");
        }
        this.maxCapacity = maxCapacity;
        this.capacity=0;
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
        if (this.getCapacity() >= maxCapacity) {
            throw new RuntimeException("Max capacity reached. Can't add element.");
        }
        this.top = new Node(a, this.top);
        capacity++;


    }

    @Override
    public void remove() {
        if(this.isEmpty()) {
            throw new RuntimeException("Can't remove from an empty stack");
        }
        this.top = this.top.getNext();
        capacity--;
    }

    @Override
    public int getCapacity() {
        return capacity;
    }
    public int getMaxCapacity(){
        return maxCapacity;
    }


}
