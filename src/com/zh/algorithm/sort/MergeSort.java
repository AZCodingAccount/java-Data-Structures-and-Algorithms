package com.zh.algorithm.sort;

import java.util.Arrays;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2023-11-15 14:27
 * @description: 归并排序的实现
 **/
public class    MergeSort {
    /*
     * 归并排序的思想是先分，分到最后一个元素的时候再治，治完以后再进行合并。采用递归实现
     * 传入三个参数，一个是原数组，一个是left指针，一个是right指针
     * */
    private static void mergeSort(int[] a, int left, int right, int[] a2) {
        int[] array=Arrays.copyOfRange(a,left,right+1);
        // System.out.println(Arrays.toString(array));
        // 递归结束条件，left==right
        if (left == right) {
            return;
        }
        // 对每个子数组进行分解【4,2,6，5,4】
        int m = left + right >>> 1;
        mergeSort(a, left, m, a2); // 分解数组左边的元素
        mergeSort(a, m + 1, right, a2);   // 分解数组右边的元素
        // 分解完成以后进行合并，合并一个数组的两个有序序列
        // 传递6个参数，分别是原数组，第一个子序列的起始索引，结束索引，第二个子序列的起始索引，结束索引，辅助数组
        merge(a, left, m, m + 1, right, a2);
        // System.out.println(Arrays.toString(a2));
        // 合并以后需要把a2的值赋值给a，表示子序列已经排序完毕了，覆盖
        System.arraycopy(a2,left,a,left,right-left+1);
    }

    private static void merge(int[] a, int left, int leftEnd, int right, int rightEnd, int[] a2) {
        // 定义两个指针i和j
        // 4 2
        int i = left;
        int j = right;
        int k = left;    // 合并后数组的索引，从left开始，因为要进行拷贝
        // 1 2 3    4 5 6 i=2 leftEnd=2
        // 这个是要相等的
        while (i <= leftEnd && j <= rightEnd) {
            if (a[i] <= a[j]) {     // 这个想不想等无所谓
                a2[k] = a[i];
                i++;
            } else {
                a2[k] = a[j];
                j++;
            }
            k++;
        }

        // 复制数组，用于处理那些上面的循环中没有处理到的数组
        if (i > leftEnd) {
            System.arraycopy(a, j, a2, k, rightEnd - j + 1);
        }
        // 复制数组，用于处理那些上面的循环中没有处理到的数组
        if (j > rightEnd) {
            System.arraycopy(a, i, a2, k, leftEnd - i + 1);
        }

    }

    public static void sort(int[] a) {
        mergeSort(a, 0, a.length - 1, new int[a.length]);
    }

    public static void main(String[] args) {
        int[] a = {4, 2, 6, 5,1};
        sort(a);
        System.out.println(Arrays.toString(a));

    }
}
