package com.zh.algorithm.sort;

import java.util.Arrays;
import java.util.OptionalInt;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-03-06 21:48
 * @description: 数组的相对排序—leetcode1122
 **/
public class RelativeSortArray {

    /*
            使用基数排序的扩展即可（max-min不大），基数排序（使用数组索引记录元素，值记录元素的个数）扩展如下：
                1：定义排序数组
                2：遍历源数组给排序数组赋值
                3：遍历排序数组将值依次取出来
            本题思路：
                修改步骤3，遍历排序数组时，首先根据arr2顺序取、最后根据排序数组原来顺序取

     */
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] arr = new int[1001];    // 1：定义排序数组。题目给出了范围
        int[] res = new int[arr1.length];  // 存储排序后结果的数组
        // 2：遍历源数组给排序数组赋值
        for (int e : arr1) {
            arr[e]++;
        }
        int k = 0;    // res数组的索引
        // 3.1：根据arr2顺序取
        for (int i : arr2) {
            while ((arr[i]--) > 0) {
                res[k++] = i;
            }
        }
        // 3.2：按照原来顺序取
        for (int i = 0; i < arr.length; i++) {
            while ((arr[i]--) > 0) {
                res[k++] = i;
            }
        }
        return res;

    }
}
