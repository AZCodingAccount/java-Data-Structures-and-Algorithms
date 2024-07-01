package com.zh.hot.sort;

import java.util.Arrays;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-07-01 15:12
 * @description: 归并排序
 **/
public class MergeSort {
    private void mergeSort(int[] a) {
        split(a, 0, a.length - 1, new int[a.length]);
    }

    /**
     * 切分的递归方法
     *
     * @param a     原始数组
     * @param left  切分的左索引
     * @param right 切分的右索引
     * @param temp  临时数组，用于合并
     */
    private void split(int[] a, int left, int right, int[] temp) {
        if (left == right) return; // 切分到只有一个元素了，“治”
        // 不停切分，“分”
        int mid = (left + right) / 2;
        split(a, left, mid, temp);
        split(a, mid + 1, right, temp);
        // 合并两个有序数组，“合”
        merge(a, left, mid, temp, mid + 1, right);
        System.arraycopy(temp, left, a, left, right - left + 1);    // 从left开始拷贝
    }

    /**
     * 合并两个有序数组
     *
     * @param a   原始数组
     * @param l1  数组1左索引
     * @param r1  数组1右索引
     * @param res 要合并到的数组
     * @param l2  数组2左索引
     * @param r2  数组2右索引
     */
    private void merge(int[] a, int l1, int r1, int[] res, int l2, int r2) {
        int p1 = l1, p2 = l2;   // 双指针分别指向两个数组的起始索引
        int p = l1;  // 新数组的索引
        // 两个数组元素比较
        while (p1 <= r1 && p2 <= r2) {
            if (a[p1] <= a[p2]) {
                res[p++] = a[p1];
                p1++;
            } else {
                res[p++] = a[p2];
                p2++;
            }
        }
        // 处理之前没有处理到的数组
        if (p1 != r1 + 1) System.arraycopy(a, p1, res, p, r1 - p1 + 1); // 第一个数组有残留
        if (p2 != r2 + 1) System.arraycopy(a, p2, res, p, r2 - p2 + 1); // 第二个数组有残留
    }

    public static void main(String[] args) {
        int[] a = {6, 2, 3, 4, 1, 7};
        new MergeSort().mergeSort(a);
        System.out.println(Arrays.toString(a));
    }
}
