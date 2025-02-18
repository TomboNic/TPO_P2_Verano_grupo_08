package org.example.ejercicio03;

public class DynamicQueueOfQueue implements QueueOfQueue {

    private Node<Queue> first;
    private Node<Queue> last;

    public DynamicQueueOfQueue() {
        this.first = null;
        this.last = null;
    }

    @Override
    public void add(Queue q) {
        Node<Queue> newNode = new Node<>(q, null);
        if (first == null) {
            first = newNode;
        } else {
            last.setNext(newNode);
        }
        last = newNode;
    }

    @Override
    public boolean isEmpty() {
        return first == null;
    }

    @Override
    public Queue getFirst() {
        if (isEmpty()) {
            throw new RuntimeException("La QueueOfQueue está vacía");
        }
        return first.getValue();
    }

    @Override
    public void remove() {
        if (isEmpty()) {
            throw new RuntimeException("No se puede eliminar de una QueueOfQueue vacía");
        }
        first = first.getNext();
        if (first == null) {
            last = null;
        }
    }

    @Override
    public QueueOfQueue concatenate(DynamicQueueOfQueue qoq1, DynamicQueueOfQueue qoq2) {
        DynamicQueueOfQueue result = new DynamicQueueOfQueue();
        Node<Queue> current = qoq1.first;
        while (current != null) {
            result.add(current.getValue());
            current = current.getNext();
        }
        current = qoq2.first;
        while (current != null) {
            result.add(current.getValue());
            current = current.getNext();
        }
        return result;
    }

    @Override
    public Queue flat() {
        DynamicQueue flatQueue = new DynamicQueue();
        Node<Queue> current = first;
        while (current != null) {
            Queue subQueue = current.getValue();
            DynamicStack tempStack = new DynamicStack();
            while (!subQueue.isEmpty()) {
                int elem = subQueue.getFirst();
                subQueue.remove();
                flatQueue.add(elem);
                tempStack.add(elem);
            }
            DynamicStack restoreStack = new DynamicStack();
            while (!tempStack.isEmpty()) {
                restoreStack.add(tempStack.getTop());
                tempStack.remove();
            }
            while (!restoreStack.isEmpty()) {
                int elem = restoreStack.getTop();
                restoreStack.remove();
                subQueue.add(elem);
            }
            current = current.getNext();
        }
        return flatQueue;
    }

    @Override
    public void reverseWithDepth() {
        Node<Queue> current = first;
        while (current != null) {
            Queue subQueue = current.getValue();
            DynamicStack tempStack = new DynamicStack();
            while (!subQueue.isEmpty()) {
                tempStack.add(subQueue.getFirst());
                subQueue.remove();
            }
            while (!tempStack.isEmpty()) {
                subQueue.add(tempStack.getTop());
                tempStack.remove();
            }
            current = current.getNext();
        }
        Node<Queue> prev = null;
        current = first;
        last = first;
        while (current != null) {
            Node<Queue> next = current.getNext();
            current.setNext(prev);
            prev = current;
            current = next;
        }
        first = prev;
    }
}
