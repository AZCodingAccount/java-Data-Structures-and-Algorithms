package com.zh.hot.sort;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-06-30 19:05
 * @description: 快速排序
 **/
public class QuickSort {
    /*
        这里直接使用双边快排+随机基准点实现
     */
    public void quickSort(int[] a) {
        quickSort(a, 0, a.length - 1);
    }

    // 递归入口
    private void quickSort(int[] a, int left, int right) {
        if (left >= right) return;  // left>=right
        int idx = partition2(a, left, right);
        quickSort(a, left, idx - 1);
        quickSort(a, idx + 1, right);
    }

    // 基础的分区，随机基准点+双边快排
    private int partition(int[] a, int left, int right) {
        int idx = (int) ((Math.random() * (right - left + 1)) + left);    // 生成[left,right]的随机索引
        swap(a, left, idx);    // 把随机值交换到前面
        int pivot = a[left];
        int i = left, j = right;    // 左右指针，i负责找大于基准点元素的，j负责找小于基准点元素的
        // 关于a[j]>pivot还是a[j]>=pivot，这个不影响，因为无论如何这个实现相等元素都会跑到一边去。但是不要都不相等。
        while (i < j) {
            // 不停找小于等于  基准点元素的
            while (i < j && a[j] >= pivot) {
                j--;
            }
            // 不停找大于基准点元素的
            while (i < j && a[i] <= pivot) {
                i++;
            }
            swap(a, i, j);
        }
        swap(a, left, i);   // 这个边界条件我的建议是背下来，最后把基准点和i的元素交换
        return i;
    }

    /*
     * 改进方法。首先这次左边和右边都是遇到相等的就停下来然后交换。
     * 同时更新i和j，这个时候可以把相等的元素打均匀。
     * */
    private int partition2(int[] a, int left, int right) {
        int randomIndex = (int) ((Math.random() * (right - left + 1)) + left);    // 生成[left,right]的随机索引
        swap(a, randomIndex, left);
        int bv = a[left];   // 每次取基准值为当前排序序列的第一个元素
        // 使用双边快排实现
        int i = left + 1;
        int j = right;
        // i小于j的时候直接开始找
        while (i <= j) {
            // 从左往右找，找到第一个比基准值大的元素(这里需要等于)
            while (i <= j && a[i] < bv) {
                i++;
            }
            // 从右往左找，使用while循环，直到找到一个比基准值小的或等于的元素
            while (i <= j && a[j] > bv) {
                j--;
            }
            // 兜底的判断，用于处理重复元素的情况。这里的两个一个++，一个--
            if (i <= j) {
                // i和j进行交换
                swap(a, i, j);
                i++;
                j--;
            }
        }
        // 当寻找完毕了，就把基准点换到i或者j这边
        swap(a, left, j);
        return j;
    }

    // 交换元素
    private void swap(int[] a, int idx1, int idx2) {
        int temp = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = temp;
    }

    // 力扣排序数组
    public int[] sortArray(int[] nums) {
        quickSort(nums);
        return nums;
    }

    // 力扣第K大元素
    public int findKthLargest(int[] nums, int k) {
        quickSort(nums);
        int res = 0;
        for (int i = nums.length - 1; i >= nums.length - k; i--) {
            res = nums[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] a = {6, 2, 3, 4, 1};
        new QuickSort().quickSort(a);
        System.out.println(Arrays.toString(a));
    }
}
