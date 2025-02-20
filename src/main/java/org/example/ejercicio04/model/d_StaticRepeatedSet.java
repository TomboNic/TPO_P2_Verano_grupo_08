package org.example.ejercicio04.model;

import java.util.Random;

public class d_StaticRepeatedSet implements RepeatedSet {
    private static final int MAX = 10000;

    // We use two parallels arrays: Elements and Quantities.
    private final int[] elements;
    private final int[] quantities;
    private int uniqueCount; // Quantity of unique elements.
    private final Random random;


    public d_StaticRepeatedSet(int[] elements, int[] quantities, Random random) {
        this.elements = elements;
        this.quantities = quantities;
        this.random = random;
    }

    private int findElement(int element) {
        for (int i = 0; i < uniqueCount; i++) {
            if (elements[i] == element) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void add(int element, int quantity) {
        if (quantity <= 0) {
            return;
        }

        int index = findElement(element);
        if (index != -1) {
            quantities[index] += quantity;
        } else {
            if (uniqueCount >= MAX) {
                throw new RuntimeException("The set is full");
            }
            elements[uniqueCount] = element;
            quantities[uniqueCount] = quantity;
            uniqueCount++;
        }
    }

    @Override
    public void remove(int element, int quantity) {
        if (quantity <= 0) {
            return;
        }

        int index = findElement(element);
        if (index != -1) {
            quantities[index] -= quantity;
            if (quantities[index] <= 0) {
                // If quantity turns 0, we delete the element.
                elements[index] = elements[uniqueCount - 1];
                quantities[index] = quantities[uniqueCount - 1];
                uniqueCount--;
            }
        }
    }


    @Override
    public int getCount(int element) {
        int index = findElement(element);
        return index != -1 ? quantities[index] : 0;
    }


    @Override
    public boolean isEmpty() {
        return uniqueCount == 0;
    }

    @Override
    public int choose() {
        if (isEmpty()) {
            throw new RuntimeException("can't choose an element from an empty set");
        }

        // Choose considering the repeated
        int totalElements = getTotalElements();
        int randomNum = random.nextInt(totalElements);

        int accumulator = 0;
        for (int i = 0; i < uniqueCount; i++) {
            accumulator += quantities[i];
            if (randomNum < accumulator) {
                return elements[i];
            }
        }

        return elements[uniqueCount - 1];
    }

    @Override
    public int getTotalElements() {
        int total = 0;
        for (int i = 0; i < uniqueCount; i++) {
            total += quantities[i];
        }
        return total;
    }

    @Override
    public int getUniqueElements() {
        return uniqueCount;
    }
}


