package com.zh.datastructures.Queue.queue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2023-11-23 23:06
 * @description: 队列测试类
 **/
public class QueueTest {
    @Test
    @DisplayName("测试环形链表实现的队列")
    public void testQueue() {
        LinkedListQueue<Integer> q = new LinkedListQueue<>(5);

        // 测试入队功能
        q.offer(1);
        q.offer(2);
        q.offer(3);
        q.offer(4);
        q.offer(5);
        assertIterableEquals(List.of(1, 2, 3, 4, 5), q);

        // 测试判满功能
        assertTrue(q.isFull());

        // 测试出队功能
        q.pool();
        q.pool();
        assertIterableEquals(List.of(3, 4, 5), q);

        // 测试查看功能
        assertEquals(q.peek(), 3);

        // 测试判空功能
        q.pool();
        q.pool();
        q.pool();
        assertTrue(q.isEmpty());

    }

    @Test
    @DisplayName("测试环形数组实现的队列")
    public void testArrayQueue() {
        ArrayQueue<Integer> q = new ArrayQueue<>(5);

        // 测试入队功能
        q.offer(1);
        q.offer(2);
        q.offer(3);
        q.offer(4);
        q.offer(5);
        System.out.println(q);

        // 测试判满功能
        assertTrue(q.isFull());

        // 测试出队功能
        q.pool();
        q.pool();
        System.out.println(q);

        // 测试查看功能
        assertEquals(q.peek(), 3);

        // 测试判空功能
        q.pool();
        q.pool();
        q.pool();
        assertTrue(q.isEmpty());

    }
}
