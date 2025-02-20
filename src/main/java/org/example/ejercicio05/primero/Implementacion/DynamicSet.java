package org.example.ejercicio05.primero.Implementacion;


import org.example.ejercicio05.primero.Interfaces.Set;
import org.example.ejercicio05.primero.Node.Node;

import java.util.Objects;
import java.util.Random;

public class DynamicSet implements Set {

    private Node node;
    private Random random;
    private int count;

    public DynamicSet() {
        this.random = new Random();
    }

    @Override
    public void add(int a) {
        if(this.isEmpty()) {
            this.node = new Node(a, null);
            this.count++;
            return;
        }

        Node aux = this.node;
        while(!Objects.isNull(aux)) {
            if(aux.getValue() == a) {
                return;
            }
            aux = aux.getNext();
        }

        this.node = new Node(a, this.node);
        this.count++;
    }

    @Override
    public void remove(int a) {
        if(this.isEmpty()) {
            return;
        }

        if(this.node.getNext() == null) {
            if(this.node.getValue() == a) {
                this.node = null;
                this.count--;
            }
            return;
        }

        if(this.node.getValue() == a) {
            this.node = this.node.getNext();
            this.count--;
            return;
        }

        Node backup = this.node;
        Node aux = this.node.getNext();
        while(!Objects.isNull(aux)) {
            if(aux.getValue() == a) {
                backup.setNext(aux.getNext());
                this.count--;
                return;
            }
            backup = aux;
            aux = aux.getNext();
        }
    }

    @Override
    public boolean isEmpty() {
        return this.node == null;
    }

    @Override
    public int choose() {
        if(this.isEmpty()) {
            throw new RuntimeException("No se puede elegir un elemento de un conjunto vacío");
        }
        if(this.node.getNext() == null) {
            return this.node.getValue();
        }
        int randomIndex = random.nextInt(count);

        int i = 0;
        Node aux = this.node;
        while(i < count) {
            if(i == randomIndex) {
                return aux.getValue();
            }
            i++;
            aux = aux.getNext();
        }

        throw new RuntimeException();
    }
}
