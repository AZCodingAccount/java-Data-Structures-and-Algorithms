package com.zh.algorithm.heap;

import com.zh.datastructures.heap.MaxHeap;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2023-12-02 17:12
 * @description: 堆排序
 **/
public class HeapSort {
    /*
     * 堆排序的实现思路是构建一个大顶堆（升序排序，降序以此类推），每次交换数组第一个元素和最后一个元素的顺序，然后重新构建大顶堆。同时size--
     * 每重新构建一次，一个元素就有序了，直到size==1为止
     * */

    public static int[] heapSort(int[] arr) {
        // 初始化大顶堆
        MaxHeap maxHeap = new MaxHeap(arr);
        // 遍历大顶堆的元素
        while (maxHeap.size > 1) {
            // 交换第一个和最后一个元素的顺序
            maxHeap.swap(0, maxHeap.size - 1);
            maxHeap.size--;
            // 重新建堆
            maxHeap.down(0);
        }

        return maxHeap.arr;
    }

    public static int[] heapSort2(int[] arr) {
        // 上面的需要自己实现数据结构，Java的优先级队列并没有暴露出那些方法
        // 因此继续考虑，首先建堆，然后构建一个小顶堆，每次取出小顶堆的一个元素加入到一个新的数组中，然后重新down。
        // 这个方法时间复杂度也是nlog(n),但是比上面的方法多了一步添加数组元素的步骤（但是是我想出来的），并且建堆的时候从n->nlog(n)了
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
        for (int i : arr) {
            minHeap.add(i);
        }
        int[] newArr = new int[arr.length];
        int index = 0;
        while (!minHeap.isEmpty()) {    // 这里必须循环到0了，因为最后一个元素也得被add到newArr里面，上面是直接在原数组操作
            newArr[index++] = minHeap.poll();
        }
        return newArr;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{4, 3, 9, 1, 2};
        int[] sortedArr = heapSort2(arr);
        System.out.println(Arrays.toString(sortedArr));
    }


}
