package com.zh.hot.heap;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-07-20 18:10
 * @description: 库存管理3—lcr159
 **/
public class InventoryManagement {
    class Heap {
        int[] arr;
        int size;

        public Heap(int[] arr) {
            this.size = arr.length;
            this.arr = arr;
            heapify();
        }

        // 建堆，弗洛伊德堆化算法
        public void heapify() {
            int nonLeafIdx = size / 2 - 1;
            for (int i = nonLeafIdx; i >= 0; i--) {
                down(i);
            }
        }

        // 将第一个元素交换到队尾，然后下潜即可
        public int poll() {
            int num = arr[0];
            swap(0, size - 1);
            size--; // 必须在下潜之前就--
            down(0);
            return num;
        }

        // 下沉
        private void down(int parent) {
            // 找到左右孩子节点
            int left = 2 * parent + 1, right = 2 * parent + 2;
            int max = parent;
            if (left < size && arr[max] > arr[left]) {
                max = left;
            }
            if (right < size && arr[max] > arr[right]) {
                max = right;
            }

            if (max != parent) {
                swap(parent, max);
                down(max);
            }
        }

        private void swap(int parent, int left) {
            int temp = arr[parent];
            arr[parent] = arr[left];
            arr[left] = temp;
        }


    }

    public int[] inventoryManagement(int[] stock, int cnt) {
        if (cnt > stock.length) return new int[]{};
        // List<Integer> res = new ArrayList<>();
        int[] res = new int[cnt];
        Heap heap = new Heap(stock);
        for (int i = 0; i < cnt; i++) {
            // res.add(heap.poll());
            res[i] = heap.poll();
        }
        // return res.stream().mapToInt(e -> e).toArray();
        return res;
    }


}
