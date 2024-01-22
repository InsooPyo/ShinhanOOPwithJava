package com.shinshan.oop.queue;

public class QueueMakingArray<E>  implements QueueAvailable<E>{
    private final E[] data;
    private int frontIndex;
    private int queueSize;

    public QueueMakingArray(int capacity) {
        data = (E[]) new Object[capacity];
        queueSize = 0;
        frontIndex = 0;
    }
    public QueueMakingArray() {
        this(1000);
    }
    public int size() {
        return queueSize;
    }
    public boolean isEmpty() {
        return (queueSize == 0);
    }
    public void enqueue(E e) throws IllegalStateException {
        if (queueSize == data.length) throw new IllegalStateException("Queue is full");
        int avail = (frontIndex + queueSize) % data.length;
        data[avail] = e;
        queueSize++;
    }
    public E first() throws IllegalStateException {
        if (queueSize == data.length) throw new IllegalStateException("Queue is empty");
        return data[frontIndex];
    }
    public E dequeue() throws IllegalStateException {
        if (queueSize == data.length) throw new IllegalStateException("Queue is empty");
        E answer = data[frontIndex];
        data[frontIndex] = null;
        frontIndex = (frontIndex + 1) % data.length;
        queueSize--;
        return answer;
    }
}

