package com.zh.hot.sort;

import java.util.Arrays;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-06-30 19:14
 * @description: 冒泡排序
 **/
public class BubbleSort {
    /*
        跟个泡泡一样，把大元素或者小元素冒上去
     */
    private void bubbleSort(int[] a) {
        int cache = a.length - 1;  // 记录前几个有序的
        int j;
        while (true) {
            if (cache == 0) return;    // 处理到最后一个元素了
            j = cache;
            for (int i = 0; i < j; i++) {
                if (a[i] > a[i + 1]) {  // 交换位置
                    int temp = a[i];
                    a[i] = a[i + 1];
                    a[i + 1] = temp;
                    cache = i;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {6, 2, 3, 4, 1};
        new BubbleSort().bubbleSort(a);
        System.out.println(Arrays.toString(a));
    }
}
