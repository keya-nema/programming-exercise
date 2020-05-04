package com.example.exercise.datastructures.stack;

public class Stack<T> {

    // Last in First Out
    int top;
    int maxSize;
    T[] symbols;

    public Stack(int length) {
        symbols = (T[]) new Object[length]; // TODO: Make generic
        top = -1; // indicates an empty array
        maxSize = length;
    }

    public void push(T symbol) {
        if (top == maxSize - 1) {
            System.out.println("com.example.exercise.datastructures.stack.Stack is full.");
        } else {
            symbols[++top] = symbol;
        }
    }

    public T pop() {
        if (top == -1) {
            System.out.println("Empty stack.");
            return null;
        } else {
            return symbols[top--];
        }
    }

    public T peek() {
        if (top > -1 && top < maxSize) {
            return symbols[top];
        } else {
            return null;
        }
    }

    public boolean isEmpty() {
        return top == -1 ? true : false;
    }

    public void printStack() {
        if (top > -1 && top < maxSize) {
            for (int i = 0; i <= top; i++) {
                System.out.println(symbols[i]);
            }
        } else {
            System.out.println("com.example.exercise.datastructures.stack.Stack doesn't have elements");
        }
    }
}
