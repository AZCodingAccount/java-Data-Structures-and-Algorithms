package com.zh.hot.sort;

import java.util.Arrays;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-07-01 10:38
 * @description: 希尔排序
 **/
public class ShellSort {
    /*
        希尔排序是对插入排序的改进，进入了O(nlog(n))俱乐部，具体来说，对于每个数，交换到属于它的位置的步长变大了，主要还是交换
     */
    private void shellSort(int[] a) {
        for (int gap = a.length >> 1; gap >= 1; gap /= 2) {
            // 把之前插入排序的默认1改成gap即可，左边比较的步长也是gap，初始化时候也是gap；
            for (int i = gap; i < a.length; i++) {
                int num = a[i], j = i - gap;
                while (j >= 0 && a[j] > num) {
                    a[j + gap] = a[j];
                    j -= gap;
                }
                if (j != i - gap) {
                    a[j + gap] = num;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {6, 2, 3, 4, 1};
        new ShellSort().shellSort(a);
        System.out.println(Arrays.toString(a));
    }
}
