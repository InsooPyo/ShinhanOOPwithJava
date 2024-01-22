package com.shinshan.oop.stack;

interface Stackable<E>{
    int size();
    boolean isEmpty();
    void push(E e);
    E peek();
    E pop();
}
