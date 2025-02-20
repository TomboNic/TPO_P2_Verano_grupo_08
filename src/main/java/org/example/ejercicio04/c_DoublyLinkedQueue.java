package org.example.ejercicio04;

public class c_DoublyLinkedQueue implements Queue {
    private DoubleNode first;
    private DoubleNode last;  // Mantenemos una referencia al último nodo

    public c_DoublyLinkedQueue() {
        this.first = null;
        this.last = null;
    }

    @Override
    public int getFirst() {
        if (isEmpty()) {
            throw new RuntimeException("No se puede obtener el primero de una cola vacía");
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
            // Si la cola está vacía, el nuevo nodo es tanto el primero como el último
            this.first = newNode;
            this.last = newNode;
        } else {
            // Agregamos el nuevo nodo al final y actualizamos los enlaces
            newNode.setPrevious(this.last);
            this.last.setNext(newNode);
            this.last = newNode;
        }
    }

    @Override
    public void remove() {
        if (isEmpty()) {
            throw new RuntimeException("No se puede desacolar de una cola vacía");
        }

        // Si solo hay un elemento
        if (this.first == this.last) {
            this.first = null;
            this.last = null;
            return;
        }

        // Removemos el primer elemento y actualizamos los enlaces
        this.first = this.first.getNext();
        this.first.setPrevious(null);
    }

    // Método adicional para obtener el último elemento
    public int getLast() {
        if (isEmpty()) {
            throw new RuntimeException("No se puede obtener el último de una cola vacía");
        }
        return this.last.getValue();
    }
}