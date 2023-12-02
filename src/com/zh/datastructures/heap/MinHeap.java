package com.zh.datastructures.heap;

import java.util.Arrays;
import java.util.Iterator;
import java.util.PriorityQueue;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2023-12-02 15:44
 * @description: 小顶堆-本次实现不考虑元素是对象的情况，假设元素都是整数
 **/
public class MinHeap implements Iterable<Integer> {

    /*
     * 小顶堆的关键方法有三个，一个是up(上浮)，down(下潜)，一个是heapify(建堆)
     *   这里我们不限制堆容量的大小，要对它进行扩容。如果需要指定容量，可以使用装饰器模式来包装PriorityQueue这个类
     * 也就是说，实现的方法有offer,poll,peek和replace（更新堆顶元素）。isFull和isEmpty不用实现，isEmpty可以实现一下。
     * */
    public int[] arr;   // 存储小顶堆元素

    private int size = 0;   // 小顶堆当前元素个数

    private int capacity;   // 小顶堆元素容量

    // 构造方法初始化
    public MinHeap(int capacity) {
        this.capacity = capacity;
        arr = new int[capacity];
    }

    // 初始化传进来一个数组
    public MinHeap(int[] arr) {
        this.arr = arr;
        heapify(arr);   // 建堆
    }

    // 初始化没有指定容量
    public MinHeap() {
        this.capacity = 10;   // 初始化容量
        arr = new int[10];
    }

    // 建堆
    private void heapify(int[] arr) {
        // 找到最后一个不是叶子节点的节点
        int n = size, i = (n >>> 1) - 1;
        // 对每一个节点都执行up操作
        for (int i1 = i; i1 > 0; i1--) {
            up(i1);
        }
    }

    public boolean offer(int e) {
        // 首先判断当前容量需不需要扩容
        if (size == capacity) {
            capacity = capacity + capacity >> 1;
            int[] newArr = new int[capacity];
            System.arraycopy(arr, 0, newArr, 0, size);
            arr = newArr;
        }
        arr[size] = e;
        // 上浮，保持小顶堆的特性
        up(size);
        size++;
        return true;
    }

    // 移除堆顶元素
    public int poll() {
        if (size == 0) {
            return 0;
        }
        int value = arr[0];
        swap(0, size - 1); // 把要移除的元素交换到堆底
        size--; // 删除该元素
        down(0);    // 下潜，维持小顶堆特性
        return value;
    }

    // 查看堆顶元素
    public int peek() {
        if (size == 0) {
            return 0;
        }
        return arr[0];
    }

    public boolean replace(int newValue) {
        if (size == 0) {
            return false;
        }
        arr[0] = newValue;    // 改变堆顶元素值
        down(0);    // 下潜
        return true;
    }

    // 下潜
    private void down(int parent) {
        int left = 2 * parent + 1;
        int right = left + 1;
        int min = parent; // 假设最小的元素是parent

        if (left < size && arr[min] > arr[left]) {
            swap(min, left); // 交换min和left对应的值
            min = left;   // 更新min的值
        }
        if (right < size && arr[min] > arr[right]) {
            swap(min, right);
            min = right;
        }
        // 如果是父元素最小的话就不用比较了
        if (min != parent) {
            // 继续下潜
            down(min);
        }
    }

    // 上浮
    private void up(int i) {
        int parent = (i - 1) / 2;   // 当前父节点索引
        if (parent >= 0 && arr[parent] > arr[i]) {
            swap(parent, i);    // 交换这两个数组的元素
            up(parent); // 继续上浮
        }

    }

    // 交换数组元素
    private void swap(int parent, int i) {
        int temp = arr[parent];
        arr[parent] = arr[i];
        arr[i] = temp;
    }


    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            int p = 0;

            @Override
            public boolean hasNext() {
                return p!=size;
            }

            @Override
            public Integer next() {
                int value=arr[p];
                p++;
                return value;
            }
        };
    }
}
