package org.example.ejercicio03;

public interface QueueOfQueue {
    void add(Queue q);         // Agrega una cola a la estructura
    boolean isEmpty();         // Retorna si la estructura está vacía
    Queue getFirst();          // Obtiene la primera cola de la estructura
    void remove();             // Elimina la primera cola
    Queue flat();              // Retorna una única cola con todos los elementos combinados
    void reverseWithDepth();   // Invierte el orden de las colas y de los elementos en cada una
}

