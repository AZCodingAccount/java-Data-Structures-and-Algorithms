package com.zh.datastructures.heap;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2023-12-02 16:50
 * @description: 堆测试
 **/
public class HeapTest {


    @Test
    @DisplayName("小顶堆测试")
    public void minHeapTest() {
        MinHeap minHeap = new MinHeap();
        // 测试插入元素
        minHeap.offer(2);
        minHeap.offer(3);
        minHeap.offer(5);
        minHeap.offer(9);
        minHeap.offer(1);
        // 1
        //2  5
        //9 3
        System.out.println(Arrays.toString(minHeap.arr));
        assertIterableEquals(List.of(1,2,5,9,3),minHeap);

        // 测试删除和查看元素
        assertEquals(1,minHeap.poll());
        assertEquals(2,minHeap.peek());
        assertEquals(2,minHeap.poll());
        // 3
        //5 9

        // 5
        //7  9
        // 测试替换元素
        minHeap.replace(7);
        assertIterableEquals(List.of(5,7,9),minHeap);
    }

    // 大顶堆实现思路类似，主要就是up和down的时候比较的符号变了而已，这里就不再测试，但是给出实现类

}
