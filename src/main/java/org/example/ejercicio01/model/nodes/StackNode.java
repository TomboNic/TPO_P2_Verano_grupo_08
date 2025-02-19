package org.example.ejercicio01.model.nodes;
import org.example.ejercicio01.model.Stack;

public class StackNode {

    private Stack value;
    private StackNode next;

    public StackNode(Stack value, StackNode next) {
        this.value = value;
        this.next = next;
    }

    public Stack getValue() {
        return value;
    }

    public void setValue(Stack value) {
        this.value = value;
    }

    public StackNode getNext() {
        return next;
    }

    public void setNext(StackNode next) {
        this.next = next;
    }
}
