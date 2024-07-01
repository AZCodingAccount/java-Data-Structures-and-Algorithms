package com.zh.hot.sort;

import java.util.Arrays;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-07-01 09:45
 * @description: 插入排序
 **/
public class InsertSort {
    /*
        插入排序时间复杂度也是O（n^2），但在小数据量情况下表现优异。稳定
     */
    private void insertSort(int[] a) {
        for (int i = 1; i < a.length; i++) {    // 控制右侧数字
            int num = a[i];
            int j = i - 1;
            // 右移左边数组，直到找到插入位置
            while (j >= 0 && a[j] > num) {  // 当前元素大于要插入的元素
                a[j + 1] = a[j];
                j--;
            }
            if (j != i - 1) {   // 寻找完成后判断j是否改变，当然不判断也可以
                a[j + 1] = num;
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {6, 2, 3, 4, 1};
        new InsertSort().insertSort(a);
        System.out.println(Arrays.toString(a));
    }
}
