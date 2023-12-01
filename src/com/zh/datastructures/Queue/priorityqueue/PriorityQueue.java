package com.zh.datastructures.Queue.priorityqueue;

import com.zh.datastructures.Queue.Queue;

import java.util.Iterator;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2023-12-01 15:59
 * @description: 优先级队列—使用大顶堆实现
 **/
public class PriorityQueue<E extends Priority> implements Queue<E>, Iterable<Integer> {
    /*
     * 使用堆实现的优先级队列还是队列，主要是使用优先级当成了这个节点在堆里面的值。且这个值存储在数组的元素中
     * 每次offer的时候要执行上浮操作。每次peek/poll的时候取出第一个元素（注意，本次使用数组实现。因为需要对索引进行频繁的操作）这时就需要size了
     * 且有一个重要的推论：左子节点的索引为2*i+1，父节点的索引相应就是(j-1)/2。用于实现down(下潜操作)
     * */
    private E[] arr;
    private int capacity;
    private int size = 0;

    public PriorityQueue(int capacity) {
        this.capacity = capacity;
        arr = (E[]) new Priority[capacity];  // 多态
    }

    @Override
    public boolean offer(E value) {
        if (isFull()) {
            return false;
        }
        // 至于为什么在数组尾部插入而不是头部，主要是效率高
        arr[size] = value;
        // 上浮
        up(size);
        size++;
        return true;
    }

    // 实现上浮
    private void up(int index) {
        int parent = (index - 1) / 2;    // 获取父元素索引
        // 递归结束条件
        if (parent < 0) {
            return;
        }
        if (arr[parent].priority() < arr[index].priority()) {
            swap(parent, index);  // 子元素上浮
            up(parent); // 继续上浮
        }
    }

    private void swap(int parent, int size) {
        E temp = arr[parent];
        arr[parent] = arr[size];
        arr[size] = temp;
    }

    @Override
    public E pool() {
        if (isEmpty()) {
            return null;
        }
        E value = arr[0];
        swap(0, size - 1);           // 交换元素，删除效率高一点
        size--;
        // 调整堆，元素下潜
        down(0);
        return value;
    }

    private void down(int i) {
        int left = i * 2 + 1;
        int right = left + 1;
        int max = i;  // 假设最大的元素是父节点的元素，不用改变(注意，比较的是arr[max],不是arr[i]如果是arr[i]会导致左右这边的比较失败)
        if (left < size && arr[left].priority() > arr[max].priority()) {
            max = left;   // 更新优先级最大的元素
        }
        if (right < size && arr[right].priority() > arr[max].priority()) {
            max = right;   // 更新优先级最大的元素
        }
        // 找到了优先级最大的元素，两种情况，一种，父节点没有变。可以结束了。另一种，max更新了，说明还得向下遍历
        if (max == i) {
            return;
        } else {
            swap(max, i);    // 交换一下堆元素的位置
            down(max);
        }
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            return null;
        }
        return arr[0];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return size == capacity;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            int p = 0;

            @Override
            public boolean hasNext() {
                return p != size;
            }

            @Override
            public Integer next() {
                int value = arr[p].priority(); // 需要重写实体对象的toString
                p++;
                return value;
            }
        };
    }
}
