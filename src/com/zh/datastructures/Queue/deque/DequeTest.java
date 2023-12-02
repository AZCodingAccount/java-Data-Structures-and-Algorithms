package com.zh.datastructures.Queue.deque;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2023-11-29 20:22
 * @description: 双端队列的测试实现
 **/
public class DequeTest {

    @DisplayName("测试双向环形链表实现的双端队列")
    @Test
    public void testLinkedListDeque() {
        LinkedListDeque<Integer> deque = new LinkedListDeque<>(5);
        // 测试队列的头部添加
        deque.offerFirst(1);
        deque.offerFirst(2);
        deque.offerFirst(3);
        assertIterableEquals(List.of(3, 2, 1), deque);

        // 测试队列的尾部添加
        // s->3->2->1->4->5->s
        deque.offerLast(4);
        deque.offerLast(5);
        assertIterableEquals(List.of(3, 2, 1, 4, 5), deque);

        // 测试队列的判满操作
        assertFalse(deque.offerFirst(8));
        assertTrue(deque.isFull());

        // 测试队列的查看操作
        assertEquals(3, deque.peekFirst());
        assertEquals(5, deque.peekLast());

        // 测试队列的头部删除操作
        deque.pollFirst();
        deque.pollFirst();
        assertIterableEquals(List.of(1, 4, 5), deque);

        // 测试队列的尾部删除
        deque.pollLast();
        deque.pollLast();
        assertIterableEquals(List.of(1), deque);

        // 测试队列的判空操作
        deque.pollFirst();
        if (!deque.isEmpty()) throw new AssertionError();
    }


    @DisplayName("测试环形数组实现的双端队列")
    @Test
    public void testArrayDeque() {
        ArrayDeque<Integer> deque = new ArrayDeque<>(5);
        // 测试队列的头部添加
        deque.offerFirst(1);
        deque.offerFirst(2);
        deque.offerFirst(3);
        assertIterableEquals(List.of(3, 2, 1), deque);

        // 测试队列的尾部添加
        // s->3->2->1->4->5->s
        deque.offerLast(4);
        deque.offerLast(5);
        assertIterableEquals(List.of(3, 2, 1, 4, 5), deque);

        // 测试队列的判满操作
        assertFalse(deque.offerFirst(8));
        assertTrue(deque.isFull());

        // 测试队列的查看操作
        assertEquals(3, deque.peekFirst());
        assertEquals(5, deque.peekLast());

        // 测试队列的头部删除操作
        deque.pollFirst();
        deque.pollFirst();
        assertIterableEquals(List.of(1, 4, 5), deque);

        // 测试队列的尾部删除
        deque.pollLast();
        deque.pollLast();
        assertIterableEquals(List.of(1), deque);

        // 测试队列的判空操作
        deque.pollFirst();
        if (!deque.isEmpty()) throw new AssertionError();
    }
}
