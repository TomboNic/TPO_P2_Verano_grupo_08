package org.example.ejercicio01.model;

public interface QueueOfStacks {

    /**
     * Precondiciones: La cola de pilas debe encontrarse inicializada y no debe estar vacía
     * Postcondiciones: Se obtiene la primera pila de la cola en cuestión
     * Estrategia de implementación: El metodo obitene el primer elemento de la cola,
     *                               que es a su vez una pila anteriormente agregada
     */
    Stack getFirst();

    /**
     * Precondiciones: La cola de pilas debe encontrarse inicializada
     * Postcondiciones: Se obtiene un resultado booleano, que determina si la cola se encuentra vacía
     * Estrategia de implementación: Devuelve True si el contador de la cola es igual a 0
     */
    boolean isEmpty();

    /**
     * Precondiciones: La cola de pilas debe encontrarse inicializada y se debe facilitar una pila por parámetro
     * Postcondiciones: La pila provista será agregada a la cola
     * Estrategia de implementación: Añade la pila provista a la última posición del contador de la cola
     */
    void add(Stack stack);

    /**
     * Precondiciones: La cola de pilas debe encontrarse inicializada y con elementos (pilas) dentro
     * Postcondiciones: Se desacolará el primer elemento de la cola
     * Estrategia de implementación: Se recorre la cola de pilas, desplazando hacia la izquierda los elementos
     *                               de la misma, y decrementando el contador.
     */
    void remove();

}
