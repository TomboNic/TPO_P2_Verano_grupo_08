package org.example.ejercicio05.primero.Interfaces;

public interface Set {

    void add(int a);
    void remove(int a);
    boolean isEmpty();

    /**
     * Precondición: No se puede elegir un elemento de un conjunto vacío
     * @return un elemento de forma aleatoria
     */
    int choose();

}
