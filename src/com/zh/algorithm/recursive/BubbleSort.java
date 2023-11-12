package com.zh.algorithm.recursive;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2023-11-07 22:02
 * @description: 冒泡排序使用递归实现
 **/
public class BubbleSort {
    public static void sort(int[] a) {
        bubbleSort(a, a.length - 1);
    }

    // 这个代表j是当前还未排序的子数组的长度（右索引）
    // 改进算法，定义一个变量x记录当前需要排序的元素右索引。（注意，这里是索引不是个数）
    public static void bubbleSort(int[] a, int j) {
        if (j <= 0) {
            return;
        }
        int x = 0;
        for (int i = 0; i < j; i++) {
            // 如果左边元素大于右边元素，就交换
            if (a[i] > a[i + 1]) {
                int temp = a[i];
                a[i] = a[i + 1];
                a[i + 1] = temp;
                x = i;
            }
        }
        bubbleSort(a, x);
    }

    @Test
    @DisplayName("冒泡排序的测试")
    public void testBubbleSort() {
        int[] arr = new int[]{3, 4, 2, 1, 8, 6};
        int[] des_arr = new int[]{1, 2, 3, 4, 6, 8};
        sort(arr);
       //  基于原来的双层for的优化，虽然有点抽象，但是也算是一个思路
       /* int x = arr.length - 1;
        for (int i = 0; i < x; ) {
            int y = x;
            for (int j = 0; j < y; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    x = j;
                }
            }
            System.out.println(x);
        }*/
        // System.out.println(Arrays.toString(arr));
        assertArrayEquals(des_arr, arr);
    }
}
