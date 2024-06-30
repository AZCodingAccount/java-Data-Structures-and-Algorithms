package com.zh.hot.sort;

import java.util.Arrays;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-06-30 19:32
 * @description: 选择排序
 **/
public class SelectSort {
    /*
        选择排序的过程在于每次找到一个最大元素或者最小元素，然后将指定元素和最大值或最小值交换，
        当然，进行两两比较也是可以的。每轮结束后也可以确定一个最大值或最小值
     */
    private void selectSort(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[min]) {
                    min = j;
                }
            }
            if (min != i) {
                // 交换元素
                int temp = a[i];
                a[i] = a[min];
                a[min] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {6, 2, 3, 4, 1};
        new SelectSort().selectSort(a);
        System.out.println(Arrays.toString(a));
    }
}
