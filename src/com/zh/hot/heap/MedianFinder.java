package com.zh.hot.heap;


import java.util.PriorityQueue;

class MedianFinder {

    PriorityQueue<Integer> minHeap; // 存储比中位数大的元素
    PriorityQueue<Integer> maxHeap; // 存储比中位数小或相等的元素

    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
    }

    // 添加元素，if这个元素大于大顶堆堆顶元素，那么就添加到小顶堆中，反之，添加到大顶堆中
    public void addNum(int num) {
        if (maxHeap.isEmpty() || num <= maxHeap.peek()) { // 优先添加到大顶堆
            maxHeap.offer(num);
            // 调整堆的相对顺序，不要让一个堆过大，这样求不了中位数
            if (maxHeap.size() - minHeap.size() > 1) {
                minHeap.offer(maxHeap.poll());
            }
        } else {
            minHeap.offer(num);
            // 维持小顶堆永远小于等于大顶堆的特性
            if (minHeap.size() > maxHeap.size()) {
                maxHeap.offer(minHeap.poll());
            }
        }
    }

    // 寻找中位数就简单了，大顶堆长度==小顶堆，那么取平均值，反之取大顶堆元素
    public double findMedian() {
        if (!maxHeap.isEmpty()) {
            if (minHeap.size() == maxHeap.size()) {
                return (minHeap.peek() + maxHeap.peek()) / 2.0;
            } else {
                return maxHeap.peek();
            }
        }
        return -1;
    }
}
