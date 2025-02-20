package org.example.ejercicio05.primero.Implementacion;


import org.example.ejercicio05.primero.Interfaces.Set;
import org.example.ejercicio05.primero.Interfaces.Stack;

public class StackSorter {

    /**
     * Recibe una pila de elementos desordenados y devuelve una nueva pila
     * sin elementos repetidos y ordenada de menor a mayor.
     *
     * Complejidad temporal: O(n²)
     * Complejidad espacial: O(n)
     *
     * @param inputStack La pila de entrada.
     * @return Una nueva pila ordenada y sin repetidos.
     */
    public Stack sortAndRemoveDuplicates(Stack inputStack) {
        if (inputStack == null || inputStack.isEmpty()) {
            return new DynamicStack();
        }

        Set seen = new DynamicSet();
        Stack tempStack = new DynamicStack();

        while (!inputStack.isEmpty()) {
            int element = inputStack.getTop();
            inputStack.remove();

            boolean isDuplicate = false;
            Stack checkStack = new DynamicStack();
            while (!tempStack.isEmpty()) {
                int tempElement = tempStack.getTop();
                tempStack.remove();
                if (tempElement == element) {
                    isDuplicate = true;
                }
                checkStack.add(tempElement);
            }

            while (!checkStack.isEmpty()) {
                int val = checkStack.getTop();
                checkStack.remove();
                tempStack.add(val);
            }

            if (!isDuplicate) {
                tempStack.add(element);
            }
        }

        Stack outputStack = new DynamicStack();
        while (!tempStack.isEmpty()) {
            int current = tempStack.getTop();
            tempStack.remove();
            while (!outputStack.isEmpty() && outputStack.getTop() > current) {
                tempStack.add(outputStack.getTop());
                outputStack.remove();
            }
            outputStack.add(current);
        }

        return outputStack;
    }
}
