package xyz.scropy.datastructers.queues;

import java.util.Queue;

public class MyQueue<T> {

    private final int maxSize;
    private final T[] array;
    private int front = -1;
    private int rear;

    private int length;

    public MyQueue(int maxSize) {
        this.maxSize = maxSize;
        this.array = (T[]) new Object[maxSize];
    }

    public void enqueue(T value) {
        if (isFull()) throw new RuntimeException("Queue is full");

        if (isEmpty()) front++;
        length++;

        if (rear == maxSize) rear = rear % maxSize;
        array[rear++] = value;
    }

    public T dequeue() {
        if (isEmpty()) return null;

        T value = array[front];
        array[front] = null;
        length--;
        front = (front + 1) % maxSize;
        return value;
    }

    private boolean isEmpty() {
        return length == 0;
    }

    private boolean isFull() {
        return length == maxSize;
    }

    public T peek() {
        if (isEmpty()) return null;

        return array[front++];
    }

    public int getLength() {
        return length;
    }

    public void print() {
        for (T value : array) {
            System.out.println(value);
        }
    }
}
