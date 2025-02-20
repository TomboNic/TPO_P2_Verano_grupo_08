package org.example.ejercicio02.util;


import org.example.ejercicio02.model.Stack;
import org.example.ejercicio02.model.StaticStack;

public class StackUtil<T> {

    public static <T> Stack<T> copy(Stack<T> stack) {
        Stack<T> aux = new StaticStack<>();
        Stack<T> copy = new StaticStack<>();

        while(!stack.isEmpty()) {
            aux.push(stack.getTop());
            copy.push(stack.getTop());
            stack.pop();
        }

        while(!copy.isEmpty()) {
            stack.push(copy.getTop());
            copy.pop();
        }

        while(!aux.isEmpty()) {
            copy.push(aux.getTop());
            aux.pop();
        }

        return copy;
    }

    public static <T> void print(Stack<T> stack) {
        Stack<T> copy = copy(stack);
        while(!copy.isEmpty()) {
            System.out.println(copy.getTop());
            copy.pop();
        }
    }

    public static <T> Stack<T> reverse(Stack<T> stack) {
        Stack<T> copy = copy(stack);
        Stack<T> result = new StaticStack<>();

        while (!copy.isEmpty()) {
            result.push(copy.getTop());
            copy.pop();
        }

        return result;
    }

}
