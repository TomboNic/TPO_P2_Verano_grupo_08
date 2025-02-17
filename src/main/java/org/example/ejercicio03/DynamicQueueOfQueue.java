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

    private void copyQueuesTo(DynamicQueueOfQueue target) {
        Node<Queue> current = this.first;
        while (current != null) {
            target.add(current.getValue());
            current = current.getNext();
        }
    }

    public static QueueOfQueue concatenate(DynamicQueueOfQueue qoq1, DynamicQueueOfQueue qoq2) {
        DynamicQueueOfQueue result = new DynamicQueueOfQueue();
        qoq1.copyQueuesTo(result);
        qoq2.copyQueuesTo(result);
        return result;
    }

    @Override
    public Queue flat() {
        DynamicQueue flatQueue = new DynamicQueue();
        Node<Queue> current = first;
        while (current != null) {
            DynamicQueue aux = new DynamicQueue();
            Queue queue = current.getValue();
            while (!queue.isEmpty()) {
                int elem = queue.getFirst();
                queue.remove();
                flatQueue.add(elem);
                aux.add(elem);
            }
            while (!aux.isEmpty()) {
                int elem = aux.getFirst();
                aux.remove();
                queue.add(elem);
            }
            current = current.getNext();
        }
        return flatQueue;
    }

    private void reverseQueue(Queue q) {
        if (q.isEmpty()) return;
        int elem = q.getFirst();
        q.remove();
        reverseQueue(q);
        q.add(elem);
    }

    @Override
    public void reverseWithDepth() {
        Node<Queue> current = first;
        while (current != null) {
            reverseQueue(current.getValue());
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
