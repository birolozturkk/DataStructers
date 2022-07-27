package xyz.scropy.datastructers.stacks;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyStackTest {

    @Test
    void shouldPopWhenStackHasValues() {
        MyStack<Integer> stack = new MyStack<>(3);
        stack.push(34);
        stack.push(27);
        stack.push(59);

        assertEquals(stack.pop(), 59);
        assertEquals(stack.pop(), 27);
        assertEquals(stack.pop(), 34);
    }

    @Test
    void shouldPushWhenStackIsNotFull() {
        MyStack<Integer> stack = new MyStack<>(1);
        stack.push(17);

        assertThrows(RuntimeException.class, () -> stack.push(46), "Stack is full");
    }

    @Test
    void shouldReturnNullWhenStackIsEmpty() {
        MyStack<Integer> stack = new MyStack<>(3);

        assertNull(stack.pop());
    }

    @Test
    void shouldPeekWhenStackHasValues() {
        MyStack<Integer> stack = new MyStack<>(3);
        assertNull(stack.peek());
        stack.push(4);
        stack.push(2);

        assertEquals(stack.peek(), 2);
    }

    @Test
    void shouldAlsoWorkWithStringTypes() {
        MyStack<String> stack = new MyStack<>(3);
        stack.push("Test");
        stack.push("Deneme");

        assertEquals(stack.peek(), "Deneme");
        assertEquals(stack.peek(), "Test");
    }
}