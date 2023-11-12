package com.zh.algorithm.recursive;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2023-11-08 20:10
 * @description: 递归版插入排序
 **/
public class InsertSort {
    public void sort(int[] a) {
        insertSort(a, 1);
    }

    // 这个是从右往左找，也可以从左往右找
    // 使用low标识已经排序完全的，low左边的全部都排序完全
    public void insertSort(int[] a, int low) {
        if (low >= a.length) {
            return;
        }
        // 初始化边界和已排序完全的值，注意这个排序完全的下标不包含low。每次调用找到target应该插入的位置
        int i = low - 1;    // 指针
        int target = a[low];    // 要比较的值

        // 初始值low为1，目标值跟low比较，从右往左排序。需要判断i的范围，避免索引越界
        while (i >= 0 && a[i] > target) {
            a[i + 1] = a[i];    // 给target空出来，之所以可以直接替换，因为本来target就是紧挨着未排序数组的第一个元素
            i--;    // 继续往左找
        }
        // 循环完毕找到target需要插入的位置
        a[i + 1] = target;
        // 更新low的位置（已排序的位置）
        insertSort(a, low + 1);
    }

    @Test
    @DisplayName("测试插入排序")
    public void testInsertSort() {
        int[] a = {2, 6, 1, 4, 9};
        int[] desA = {1, 2, 4, 6, 9};
        sort(a);
        assertArrayEquals(desA, a, "插入排序错误");
    }
}
