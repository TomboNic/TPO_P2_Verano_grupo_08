package org.example.ejercicio04.util;

import org.example.ejercicio04.model.RepeatedSet;

import java.util.Arrays;
import java.util.Random;

abstract class d_StaticRepeatedSetUtil implements RepeatedSet {

    private static final int MAX = 10000;

    // Usamos dos arrays paralelos: uno para elementos y otro para sus cantidades
    private final int[] elements;
    private final int[] quantities;
    private int uniqueCount; // Cantidad de elementos únicos
    private final Random random;


    d_StaticRepeatedSetUtil(int[] elements, int[] quantities, Random random) {
        this.elements = elements;
        this.quantities = quantities;
        this.random = random;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        d_StaticRepeatedSetUtil other = (d_StaticRepeatedSetUtil) o;
        if (uniqueCount != other.uniqueCount) return false;

        // Creamos copias ordenadas para comparar
        int[] sortedElements = Arrays.copyOf(elements, uniqueCount);
        int[] sortedQuantities = Arrays.copyOf(quantities, uniqueCount);
        int[] otherSortedElements = Arrays.copyOf(other.elements, uniqueCount);
        int[] otherSortedQuantities = Arrays.copyOf(other.quantities, uniqueCount);

        // Ordenamos los elementos y sus cantidades correspondientes
        sortElements(sortedElements, sortedQuantities);
        sortElements(otherSortedElements, otherSortedQuantities);

        return Arrays.equals(sortedElements, otherSortedElements) &&
                Arrays.equals(sortedQuantities, otherSortedQuantities);
    }

    private void sortElements(int[] elements, int[] quantities) {
        for (int i = 0; i < uniqueCount - 1; i++) {
            for (int j = 0; j < uniqueCount - i - 1; j++) {
                if (elements[j] > elements[j + 1]) {
                    // Intercambiamos elementos
                    int tempElement = elements[j];
                    elements[j] = elements[j + 1];
                    elements[j + 1] = tempElement;

                    // Intercambiamos cantidades
                    int tempQuantity = quantities[j];
                    quantities[j] = quantities[j + 1];
                    quantities[j + 1] = tempQuantity;
                }
            }
        }
    }

    private int findElement(int element) {
        for (int i = 0; i < uniqueCount; i++) {
            if (elements[i] == element) {
                return i;
            }
        }
        return -1;
    }

}
