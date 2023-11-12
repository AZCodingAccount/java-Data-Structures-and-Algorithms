package com.zh.algorithm.recursive;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2023-11-07 21:32
 * @description: 二分查找递归版本
 **/
public class BinarySearch {
    // 对外部隐藏方法实现的细节
    public int binarySearch(int[] a, int target) {
        return binarySearch(a, target, 0, a.length - 1);
    }

    // 这个版本不考虑重复元素的情况
    public static int binarySearch(int[] a, int target, int i, int j) {
        if (i > j) {
            return -1;
        }
        int m = (i + j) >>> 1;
        if (a[m] > target) {
            return binarySearch(a, target, m + 1, j);
        } else if (a[m] < target) {
            return binarySearch(a, target, i, m - 1);
        } else {
            return m;
        }
    }

    @Test
    @DisplayName("测试二分查找的结果")
    public void testBinarySearch() {
        int[] a = new int[]{1, 2, 3, 4, 5, 10};
        assertEquals(2, binarySearch(a, 3), "二分查找出现了问题");
        assertEquals(-1, binarySearch(a, 6), "二分查找出现了问题");
    }
}
