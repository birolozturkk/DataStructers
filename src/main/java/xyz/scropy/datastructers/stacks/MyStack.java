package xyz.scropy.datastructers.stacks;

public class MyStack<T> {

    private int maxSize;
    private int top = -1;
    private T[] array;

    public MyStack(int maxSize) {
        this.maxSize = maxSize;
        array = (T[]) new Object[maxSize];
    }

    public void push(T value) {
        if(isFull()) throw new RuntimeException("Stack is full");

        array[++top] = value;
    }

    public T pop() {
        if (isEmpty()) return null;

        T value = array[top];
        array[top--] = null;
        return value;
    }

    public T peek() {
        if(isEmpty()) return null;

        return array[top--];
    }

    private boolean isEmpty() {
        return top == -1;
    }

    private boolean isFull() {
        return top == maxSize - 1;
    }
}
