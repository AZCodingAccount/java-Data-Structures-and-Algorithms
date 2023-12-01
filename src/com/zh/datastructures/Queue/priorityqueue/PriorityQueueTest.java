package com.zh.datastructures.Queue.priorityqueue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2023-12-01 16:43
 * @description: 优先级队列测试
 **/
public class PriorityQueueTest {

    @Test
    @DisplayName("优先级队列测试")
    public void priorityQueueTest() {
        PriorityQueue<Entity> queue = new PriorityQueue<>(5);
        // 测试offer方法
        queue.offer(new Entity("节点A", 5));
        queue.offer(new Entity("节点B", 15));
        queue.offer(new Entity("节点C", 10));
        queue.offer(new Entity("节点D", 20));
        queue.offer(new Entity("节点E", 1));
        //   20
        // 15    10
        // 5  1
        assertFalse(queue.offer(new Entity("节点A", 5)));
        assertIterableEquals(List.of(20, 15, 10, 5, 1), queue);

        // 测试判满
        assertTrue(queue.isFull());

        // 测试poll和peek
        assertEquals(20, queue.pool().priority());
        assertEquals("节点B", queue.pool().name);
        assertEquals(10, queue.peek().priority());
        queue.pool();
        queue.pool();
        queue.pool();

        // 测试判空
        assertTrue(queue.isEmpty());

    }
}
