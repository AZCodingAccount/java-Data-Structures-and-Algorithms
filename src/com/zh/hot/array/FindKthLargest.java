package com.zh.hot.array;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-06-30 21:54
 * @description: 数组中的第K大元素—lc215
 **/
public class FindKthLargest {
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
            int polled = arr[0];
            // 首先交换最后一个元素和第一个元素，然后下沉即可。
            swap(0, size - 1);
            size--;
            down(0);
            return polled;
        }

        // 下潜
        private void down(int parent) {
            int left = 2 * parent + 1, right = left + 1, max = parent;  // 左孩子右孩子的索引与默认父节点最大
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

        // 交换两个索引的元素
        private void swap(int curr, int parent) {
            int temp = arr[curr];
            arr[curr] = arr[parent];
            arr[parent] = temp;
        }

    }

    public int findKthLargest(int[] nums, int k) {
        Heap heap = new Heap(nums);
        while (k-- > 1) {
            heap.poll();
        }
        return heap.poll();
    }
}
