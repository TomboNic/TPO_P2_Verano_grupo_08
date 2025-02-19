package org.example.ejercicio01.model;
import org.example.ejercicio01.model.nodes.StackNode;

public class DynamicQueueOfStacks implements QueueOfStacks {

    private StackNode first;

    @Override
    public Stack getFirst() {
        if (this.isEmpty()) {
            throw new RuntimeException("No se puede obtener el primero de una cola vacia");
        }
        return this.first.getValue();
    }

    @Override
    public boolean isEmpty() {
        return this.first == null;
    }

    @Override
    public void add(Stack stack) {
        if (this.first == null) {
            this.first = new StackNode(stack, null);
            return;
        }

        StackNode candidate = this.first;
        while (candidate.getNext() != null) {
            candidate = candidate.getNext();
        }

        candidate.setNext(new StackNode(stack, null));
    }

    @Override
    public void remove() {
        if (this.isEmpty()) {
            throw new RuntimeException("No se puede desacolar de una cola vacia");
        }
        this.first = this.first.getNext();
    }
}
