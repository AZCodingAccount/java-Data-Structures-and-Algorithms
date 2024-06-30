package com.zh.hot.sort;

import java.util.Arrays;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-06-30 21:19
 * @description: 堆排序
 **/
public class HeapSort {
    /*
        最典型的应用就是TOP K，要么你默写出来一个大顶堆，要么快排，这里实现一下关键的堆的方法，heapify、down、poll。
        up是尾插法实现的，这里先不实现。
        记住：
        2*i+1，2*i+2，(i-1)/2，i/2-1，这四个叶子结点和父节点的公式，以及第一个非叶子节点的公式
     */

    static class Heap {
        int[] arr;
        int size = 0;

        public Heap(int[] arr) {
            this.arr = arr;
            this.size = arr.length;
            heapify();
        }

        // 堆化
        private void heapify() {
            // 弗洛伊德堆化算法
            int nonLeafIndex = size / 2 - 1;
            for (int i = nonLeafIndex; i >= 0; i--) {
                down(i);
            }
        }

        // 取出元素
        private int poll() {
            if (size == 0) throw new RuntimeException();
            int polled = arr[0];
            // 首先交换最后一个元素和第一个元素，然后下沉即可。
            swap(0, size - 1);
            size--;
            down(0);    // 先size--，再下潜，不然之前删除的那个元素还是会参与比较
            return polled;
        }

        // 下潜
        private void down(int parent) {
            int left = 2 * parent + 1;
            int right = left + 1;
            int max = parent;
            // 比较left和right哪个值更大
            if (left < size && arr[left] > arr[max]) {
                max = left;
            }
            if (right < size && arr[right] > arr[max]) {
                max = right;
            }
            if (max != parent) {    // 如果还需要继续下潜的话
                swap(max, parent);// 交换两个节点
                down(max);  // 继续下潜
            }
        }

        private void swap(int curr, int parent) {
            int temp = arr[curr];
            arr[curr] = arr[parent];
            arr[parent] = temp;
        }

    }


    // 堆排序的思想很简单，就是把快排里面找最大值或者最小值的方法用堆实现了，这样可以达到nlog(n)的级别
    private void heapSort(int[] a) {
        Heap heap = new Heap(a);
        System.out.println(Arrays.toString(a));
        for (int i = a.length - 1; i >= 0; i--) {
            // 拿到最大值
            int max = heap.poll();
            a[i] = max; // 直接赋值，不用交换，因为原始值都存到大顶堆里面了
        }
    }

    public static void main(String[] args) {
        int[] a = {6, 2, 3, 4, 1};
        new HeapSort().heapSort(a);
        System.out.println(Arrays.toString(a));
    }
}
