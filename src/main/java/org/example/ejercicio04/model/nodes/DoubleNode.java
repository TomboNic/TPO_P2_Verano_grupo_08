package org.example.ejercicio04.model.nodes;

public class DoubleNode {
    private int value;
    private DoubleNode next;
    private DoubleNode previous;

    public DoubleNode(int value, DoubleNode next, DoubleNode previous) {
        this.value = value;
        this.next = next;
        this.previous = previous;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public DoubleNode getNext() {
        return next;
    }

    public void setNext(DoubleNode next) {
        this.next = next;
    }

    public DoubleNode getPrevious() {
        return previous;
    }

    public void setPrevious(DoubleNode previous) {
        this.previous = previous;
    }
}