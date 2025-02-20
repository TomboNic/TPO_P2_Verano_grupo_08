package org.example.ejercicio05.tercero.Implementacion;

import org.example.ejercicio05.tercero.Interface.Stack;

public class BalancedParenthesesChecker {

    /**
     * Verifica si los paréntesis están balanceados en una cadena, ignorando los paréntesis dentro de comillas.
     *
     * Complejidad temporal: O(n)
     * Complejidad espacial: O(n)
     *
     * @param input La cadena de entrada.
     * @return true si los paréntesis están balanceados, false en caso contrario.
     */
    public boolean isBalanced(String input) {
        if (input == null || input.isEmpty()) {
            return true;
        }

        Stack stack = new DynamicStack();
        boolean insideSingleQuote = false;
        boolean insideDoubleQuote = false;

        for (char c : input.toCharArray()) {
            if (c == '\'' && !insideDoubleQuote) {
                insideSingleQuote = !insideSingleQuote;
            } else if (c == '"' && !insideSingleQuote) {
                insideDoubleQuote = !insideDoubleQuote;
            }

            if (!insideSingleQuote && !insideDoubleQuote) {
                if (c == '(' || c == '[' || c == '{') {
                    stack.add(c);
                } else if (c == ')') {
                    if (stack.isEmpty() || stack.getTop() != '(') return false;
                    stack.remove();
                } else if (c == ']') {
                    if (stack.isEmpty() || stack.getTop() != '[') return false;
                    stack.remove();
                } else if (c == '}') {
                    if (stack.isEmpty() || stack.getTop() != '{') return false;
                    stack.remove();
                }
            }
        }

        return stack.isEmpty();
    }
}
