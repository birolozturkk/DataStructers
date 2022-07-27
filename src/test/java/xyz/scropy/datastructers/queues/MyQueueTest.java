package xyz.scropy.datastructers.queues;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyQueueTest {

    @Test
    void shouldEnqueueWhenQueueIsNotFull() {
        MyQueue<Integer> queue = new MyQueue<>(3);
        queue.enqueue(4);
        queue.enqueue(19);
        queue.enqueue(21);
        assertThrows(RuntimeException.class, () -> queue.enqueue(54), "Queue is full");
    }

    @Test
    void shouldReturnNullWhenIsEmpty() {
        MyQueue<Integer> queue = new MyQueue<>(3);

        assertNull(queue.dequeue());
    }

    @Test
    void shouldDequeueWhenQueueHasValues() {
        MyQueue<Integer> queue = new MyQueue<>(3);
        assertNull(queue.dequeue());
        queue.enqueue(4);
        queue.enqueue(19);
        queue.enqueue(23);

        assertEquals(queue.dequeue(), 4);
        assertEquals(queue.dequeue(), 19);
        assertEquals(queue.dequeue(), 23);
    }

    @Test
    void shouldAlsoWorkWithStringType() {
        MyQueue<String> queue = new MyQueue<>(3);
        queue.enqueue("Deneme");
        queue.enqueue("Test");

        assertEquals(queue.dequeue(), "Deneme");
        assertEquals(queue.dequeue(), "Test");
    }

    @Test
    void shouldPeekWithoutRemovingValues() {
        MyQueue<Integer> queue = new MyQueue<>(3);

        assertNull(queue.peek());

        queue.enqueue(4);
        queue.enqueue(19);
        queue.enqueue(23);
        assertEquals(queue.peek(), 4);
    }

    @Test
    void shouldReturnNullWhenQueueIsEmpty() {
        MyQueue<Integer> queue = new MyQueue<>(3);
        assertNull(queue.dequeue());
    }

    @Test
    void shouldCalculateNumberOfItems() {
        MyQueue<Integer> queue = new MyQueue<>(3);
        queue.enqueue(4);
        queue.enqueue(19);
        queue.enqueue(23);

        assertEquals(queue.getLength(), 3);

        queue.dequeue();

        assertEquals(queue.getLength(), 2);

        queue.enqueue(7);

        assertEquals(queue.getLength(), 3);
    }

    @Test
    void shouldEnqueueValueWhenRearIsBeyondQueueLimit() {
        MyQueue<Integer> queue = new MyQueue<>(3);
        queue.enqueue(4);
        queue.enqueue(19);
        queue.enqueue(23);
        queue.print();
        queue.dequeue();
        queue.print();
        assertDoesNotThrow(() -> queue.enqueue(76), "Queue is full");
        queue.print();
    }

}