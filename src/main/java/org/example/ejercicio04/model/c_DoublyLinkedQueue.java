package org.example.ejercicio04.model;

import org.example.ejercicio04.model.nodes.DoubleNode;

public class c_DoublyLinkedQueue implements Queue {
    private DoubleNode first;
    private DoubleNode last;  // Keep the refference to the last node

    public c_DoublyLinkedQueue() {
        this.first = null;
        this.last = null;
    }

    @Override
    public int getFirst() {
        if (isEmpty()) {
            throw new RuntimeException("Can't obtain the first from an empty queue");
        }
        return this.first.getValue();
    }

    @Override
    public boolean isEmpty() {
        return this.first == null;
    }

    @Override
    public void add(int value) {
        DoubleNode newNode = new DoubleNode(value, null, null);

        if (isEmpty()) {
            // If the queue is empty, the first node will assume the atribute first, and last.
            this.first = newNode;
            this.last = newNode;
        } else {
            // Add the new node at the end, and update the links.
            newNode.setPrevious(this.last);
            this.last.setNext(newNode);
            this.last = newNode;
        }
    }

    @Override
    public void remove() {
        if (isEmpty()) {
            throw new RuntimeException("Can't remove from an empty queue");
        }

        // Si solo hay un elemento
        if (this.first == this.last) {
            this.first = null;
            this.last = null;
            return;
        }

        // Remove the first element and update the links
        this.first = this.first.getNext();
        this.first.setPrevious(null);
    }

    // Get the last element
    public int getLast() {
        if (isEmpty()) {
            throw new RuntimeException("Can't get the last element from an empty queue");
        }
        return this.last.getValue();
    }
}