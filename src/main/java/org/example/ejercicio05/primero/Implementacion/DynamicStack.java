package org.example.ejercicio05.primero.Implementacion;


import org.example.ejercicio05.primero.Interfaces.Stack;
import org.example.ejercicio05.primero.Node.Node;

public class DynamicStack implements Stack {

    private Node top;

    @Override
    public int getTop() {
        if(this.isEmpty()) {
            throw new RuntimeException("No se puede obtener el tope de una pila vacia");
        }
        return this.top.getValue();
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
            throw new RuntimeException("No se puede desapilar de una pila vacia");
        }
        this.top = this.top.getNext();
    }
}
