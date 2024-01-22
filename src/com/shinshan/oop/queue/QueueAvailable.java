package com.shinshan.oop.queue;

public interface QueueAvailable<E> {
    int size();
    boolean isEmpty();
    E first();
    void enqueue(E e);
    E dequeue();
}
