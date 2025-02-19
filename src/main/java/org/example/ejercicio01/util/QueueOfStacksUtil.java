package org.example.ejercicio01.util;
import org.example.ejercicio01.model.*;

public class QueueOfStacksUtil {

    public static void printQueueOfStacks(QueueOfStacks queue) {
        QueueOfStacks tempQueue = new StaticQueueOfStacks();

        while (!queue.isEmpty()) {
            Stack currentStack = queue.getFirst();
            queue.remove();

            Stack tempStack = new StaticStack();

            while (!currentStack.isEmpty()) {
                tempStack.add(currentStack.getTop());
                currentStack.remove();
            }

            while (!tempStack.isEmpty()) {
                int value = tempStack.getTop();
                tempStack.remove();
                System.out.print(value + " ");
                currentStack.add(value);
            }

            System.out.println();
            tempQueue.add(currentStack);
        }

        while (!tempQueue.isEmpty()) {
            queue.add(tempQueue.getFirst());
            tempQueue.remove();
        }
    }

    /**
     * Esta función se encarga de calcular la traza de una QueueOfStacks interpretada como matriz.
     * La traza es la suma de los elementos en la diagonal principal.
     *
     * @param queue Cola de pilas a procesar
     * @return La suma de los elementos en la diagonal principal de la cola provista.
     *
     * Complejidad temporal: Recorre la cola de pilas y, para cada pila, recorre sus elementos.
     * Si asumimos que hay m pilas y cada pila tiene un promedio de k elementos, la complejidad temporal es:
     * 𝑂(𝑚⋅𝑘)
     * Complejidad espacial: Utiliza una pila auxiliar para almacenar los elementos de cada pila, lo que consume
     * 𝑂(𝑘) espacio adicional.
     * Por lo tanto, la complejidad espacial es:
     * 𝑂(𝑘)
     */

    public static int trace(QueueOfStacks queue) {

        int trace = 0;
        int position = 0;
        QueueOfStacks auxQueue = new StaticQueueOfStacks();

        if (queue.isEmpty()) {
            throw new RuntimeException("No se puede calcular la traza de una cola de pilas vacía");
        }

        while (!queue.isEmpty()) {
            Stack current = queue.getFirst();
            Stack auxStack = new StaticStack();

            int element = 0;
            while (!current.isEmpty()) {
                int value = current.getTop();
                auxStack.add(value);
                current.remove();

                if (element == position) {
                    trace += value;
                }
                element++;
            }

            while (!auxStack.isEmpty()) {
                current.add(auxStack.getTop());
                auxStack.remove();
            }

            auxQueue.add(current);
            queue.remove();
            position++;
        }

        while (!auxQueue.isEmpty()) {
            queue.add(auxQueue.getFirst());
            auxQueue.remove();
        }

        return trace;
    }

    /**
     * Esta función se encarga de obtener la traspuesta de una QueueOfStacks interpretada como matriz.*
     *
     * @param queueOfStacks Cola de pilas a procesar
     * @return Traspuesta de la matriz interpretada
     *
     * Complejidad temporal: En el peor de los casos, recorre toda la cola de pilas y cada pila. Por lo tanto
     * la complejidad temporal es: O(m⋅k)
     *
     * Complejidad espacial: El espacio es proporcional al número de elementos en una pila, entonces:
     * O(k).
     */

    public static QueueOfStacks transpose(QueueOfStacks queueOfStacks) {
        if (queueOfStacks.isEmpty()) {
            throw new RuntimeException("No se puede obtener la traspuesta de una cola de pilas vacía");
        }

        QueueOfStacks auxOriginal = new StaticQueueOfStacks();
        QueueOfStacks transposed = new StaticQueueOfStacks();

        int n = 0;

        while (!queueOfStacks.isEmpty()) {
            Stack current = queueOfStacks.getFirst();
            n++;

            Stack tempStack = new StaticStack();

            while (!current.isEmpty()) {
                tempStack.add(current.getTop());
                current.remove();
            }

            while (!tempStack.isEmpty()) {
                current.add(tempStack.getTop());
                tempStack.remove();
            }

            auxOriginal.add(current);
            queueOfStacks.remove();
        }

        while (!auxOriginal.isEmpty()) {
            queueOfStacks.add(auxOriginal.getFirst());
            auxOriginal.remove();
        }

        for (int i = 0; i < n; i++) {
            Stack newStack = new StaticStack();
            QueueOfStacks tempQueue = new StaticQueueOfStacks();

            while (!queueOfStacks.isEmpty()) {
                Stack current = queueOfStacks.getFirst();
                Stack auxStack = new StaticStack();

                int count = 0;
                while (!current.isEmpty()) {
                    int value = current.getTop();
                    auxStack.add(value);
                    current.remove();
                    if (count == i) {
                        newStack.add(value);
                    }
                    count++;
                }

                while (!auxStack.isEmpty()) {
                    current.add(auxStack.getTop());
                    auxStack.remove();
                }

                tempQueue.add(current);
                queueOfStacks.remove();
            }

            while (!tempQueue.isEmpty()) {
                queueOfStacks.add(tempQueue.getFirst());
                tempQueue.remove();
            }

            transposed.add(newStack);
        }

        return transposed;
    }


    /**
     * Esta función se encarga de generar una matriz carol, de dimensión n, a partir de una QueueOfStacks
     * @param n dimensión de la matriz caracol
     * @return Matriz caracol, generada a partir de la QueueOfStacks
     *
     * Complejidad temporal: 𝑂(𝑛2)
     *
     * Complejidad espacial: O(n2).
     */

    public static QueueOfStacks snail(int n) {
        if (n <= 0) {
            throw new RuntimeException("El tamaño de la matriz debe ser mayor que 0");
        }

        QueueOfStacks matrix = new StaticQueueOfStacks();

        for (int i = 0; i < n; i++) {
            matrix.add(new StaticStack());
        }

        int[][] directions = { {0, 1}, {1, 0}, {0, -1}, {-1, 0} }; // Derecha, Abajo, Izquierda, Arriba
        boolean[][] visited = new boolean[n][n];
        int row = 0, col = 0, dir = 0;

        for (int num = 1; num <= n * n; num++) {

            QueueOfStacks tempQueue = new StaticQueueOfStacks();
            Stack targetRow = null;

            for (int i = 0; i < n; i++) {
                Stack currentStack = matrix.getFirst();
                matrix.remove();
                tempQueue.add(currentStack);

                if (i == row) {
                    targetRow = currentStack;
                }
            }

            Stack tempStack = new StaticStack();

            while (!targetRow.isEmpty()) {
                tempStack.add(targetRow.getTop());
                targetRow.remove();
            }

            targetRow.add(num);

            while (!tempStack.isEmpty()) {
                targetRow.add(tempStack.getTop());
                tempStack.remove();
            }

            while (!tempQueue.isEmpty()) {
                matrix.add(tempQueue.getFirst());
                tempQueue.remove();
            }

            visited[row][col] = true;

            int nextRow = row + directions[dir][0];
            int nextCol = col + directions[dir][1];

            if (nextRow < 0 || nextRow >= n || nextCol < 0 || nextCol >= n || visited[nextRow][nextCol]) {
                dir = (dir + 1) % 4;
                nextRow = row + directions[dir][0];
                nextCol = col + directions[dir][1];
            }

            row = nextRow;
            col = nextCol;
        }

        return matrix;
    }


}

