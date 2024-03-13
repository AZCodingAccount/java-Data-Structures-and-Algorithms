package com.zh.algorithm.divideconquer;


import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-03-13 16:29
 * @description: 数组中的第K大的元素——215
 **/
public class FindKthLargest {
    /*
            给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
        请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
        你必须设计并实现时间复杂度为 O(n) 的算法解决此问题。

            快排的分区，分区函数返回一个选中元素的索引，拿这个索引跟k比较继续找就行了，
        时间复杂度 n+n/2+n/4+...+1<n*2

        有个测试用例很多相等的过不去，要么用三向切分、要么随机基准点也能过，还遇到了数组元素顺序也能打乱
     */
    public int findKthLargest(int[] nums, int k) {
        // 打乱元素顺序
        int n = nums.length;
        Random r = new Random();
        for (int j = n - 1; j > 0; j--) {
            int i = r.nextInt(j + 1);
            swap(nums, i, j);
        }
        return rec(nums, 0, nums.length - 1, k);
    }

    /**
     * @param nums  原数组
     * @param left  数组左指针
     * @param right 数组右指针
     * @param k     要找的第k大的元素
     * @return int
     * @author AlbertZhang
     * @description 递归函数
     * @date 2024-03-13 17:55
     **/
    private int rec(int[] nums, int left, int right, int k) {

        int i = partition(nums, left, right);
        if (i == k - 1) {       // 找到
            return nums[i];
        } else if (i > k - 1) {     // 找左边的
            return rec(nums, left, i - 1, k);
        } else if (i < k - 1) {     // 找右边的
            return rec(nums, i + 1, right, k);
        }
        return 0;
    }

    /**
     * @param nums
     * @param left
     * @param right
     * @return int  旧数组基准点在新数组的索引
     * @author AlbertZhang
     * @description 用于给数组分区
     * @date 2024-03-13 17:59
     **/
    public static int partition(int[] nums, int left, int right) {
        int randomIndex = ThreadLocalRandom.current().nextInt(right - left + 1) + left;
        swap(nums, randomIndex, left);
        int pv = nums[left];   // 每次取基准值为当前排序序列的第一个元素
        int i = left;
        int j = right;
        while (i < j) {
            while (i < j && nums[j] < pv) {
                j--;
            }

            while (i < j && nums[i] >= pv) {
                i++;
            }
            swap(nums, i, j);
        }
        swap(nums, left, i);

        return i;
    }

    /*
    交换元素
     */
    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        System.out.println(new FindKthLargest().findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));
    }
}
