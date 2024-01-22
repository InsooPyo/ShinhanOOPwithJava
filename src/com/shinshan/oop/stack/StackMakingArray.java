package com.shinshan.oop.stack;

import java.util.EmptyStackException;

public class StackMakingArray<E> implements Stackable<E>{
    public static final int CAPACITY = 1000;
    private int topIndex;
    private final E [] data;

    public StackMakingArray() {
        this(CAPACITY);
    }
    public StackMakingArray(int capacity) {
        topIndex = -1;
        data = (E[]) new Object[capacity];
    }
    public int size() {
        return (topIndex + 1);
    }
    public boolean isEmpty() {
        return (topIndex == -1);
    }
    public void push(E e) throws IllegalStateException {
        if (size() == data.length) throw new IllegalStateException("Stack is full");
        data[++topIndex] = e;
    }

    public E peek() throws EmptyStackException {
        if (isEmpty()) throw new EmptyStackException();
        return data[topIndex];
    }

    public E pop() throws EmptyStackException {
        if (isEmpty()) throw new EmptyStackException();
        E topItem = data[topIndex];
        data[topIndex] = null;
        topIndex--;
        return topItem;
    }
}

