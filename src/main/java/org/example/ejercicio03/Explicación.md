# DynamicQueueOfQueue

## Introducción
`DynamicQueueOfQueue` es una estructura de datos que contiene colas dentro de una cola principal. Cada elemento dentro de esta estructura es otra cola, permitiendo organizar y manipular conjuntos de colas de manera eficiente.

## Concepto Visual
Imagina `DynamicQueueOfQueue` como una fila de cajas, donde cada caja es una cola que contiene varios elementos ordenados. Puedes agregar nuevas cajas, extraer la primera caja de la fila, combinar el contenido de todas en una sola caja o incluso invertir el orden de las cajas y su contenido interno.

## Funcionamiento General
1. **Almacena colas**: Cada elemento dentro de `DynamicQueueOfQueue` es una cola individual que puede contener múltiples valores.
2. **Aplanamiento (`flat`)**: Convierte la estructura en una sola cola con todos los elementos ordenados secuencialmente.
3. **Inversión (`reverseWithDepth`)**: Cambia el orden de las colas y de los elementos dentro de cada una.
4. **Concatenación (`concatenate`)**: Une dos estructuras `DynamicQueueOfQueue` en una sola manteniendo el orden de las colas originales.

## Ejemplo Visual
Si tenemos la siguiente `DynamicQueueOfQueue`:
```
[ [1, 2, 3], [4, 5, 6], [7, 8] ]
```
- `flat()` produciría: `[1, 2, 3, 4, 5, 6, 7, 8]`
- `reverseWithDepth()` produciría: `[7, 8] -> [4, 5, 6] -> [1, 2, 3]`, con cada cola invertida internamente.
- `concatenate(qoq1, qoq2)` uniría dos estructuras en una más grande.

## Conclusión
`DynamicQueueOfQueue` proporciona una solución flexible para manejar múltiples colas dentro de una estructura unificada. Su uso es útil en escenarios donde se requiere manejar múltiples flujos de datos de manera ordenada y eficiente.

