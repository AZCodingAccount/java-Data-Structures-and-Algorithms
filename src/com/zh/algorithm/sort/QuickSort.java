package com.zh.algorithm.sort;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2023-11-15 15:20
 * @description: 快速排序
 **/
public class QuickSort {
    /*
     * 快速排序的流程是选定一个基准点，分成大于这个基准点的和小于这个基准点的，把这两堆分别进行排序。
     * 快排是基于比较的最快的算法，但是有两种情况会让快排时间复杂度达到n^2量级，
     * 一个是待排序的数组本身是降序的，但是需要按照升序排列。——>解决方法是随机基准点
     * 还有一种是数组元素几乎全相等。——>解决方法是改写算法
     * 还有一种优化的思想是快排和插入排序结合使用，因为插入排序在数据量小的时候具有良好的性能
     * */

    // a代表原数组，left代表左指针，right代表右指针
    public static void plainQuickSort(int[] a, int left, int right) {
        // 递归出口，注意是left>=right，因为p为0的情况下就会如果相等就会爆栈
        if (left >= right) {
            return;
        }
        // 每次递归先排好一个元素，然后分别排这个元素左边的和这个元素右边的
        int p = leetcodePartition(a, left, right);  // 这个方法用于寻找当前特定元素的索引
        quickSort(a, left, p - 1);  // 排索引左边的部分元素
        quickSort(a, p + 1, right); // 排索引右边的部分元素
    }

    private static int partition(int[] a, int left, int right) {
        int bv = a[left];   // 每次取基准值为当前排序序列的第一个元素
        // 使用双边快排实现
        int i = left;
        int j = right;
        // i小于j的时候直接开始找
        while (i < j) {
            // 先从右往左找，使用while循环，直到找到一个比基准值小的或等的元素
            while (i < j && a[j] > bv) {
                j--;
            }
            // 同理，找到第一个比基准值大的元素(这里需要等于)
            while (i < j && a[i] <= bv) {
                i++;
            }
            // i和j进行交换
            swap(a, i, j);
        }
        // 当寻找完毕了，就把基准点换到i或者j这边
        swap(a, left, i);
        System.out.println(i);
        return i;
    }

    /*
     * 改进方法。首先这次左边和右边都是遇到相等的就停下来然后交换。
     * 同时更新i和j，其实这个我也不太理解，知道怎么优化的就可以了。有点迷惑，但是这种应对方案直接用下面的三向切分快一点
     * */
    private static int leetcodePartition(int[] a, int left, int right) {
        int randomIndex = ThreadLocalRandom.current().nextInt(right - left + 1) + left;
        swap(a, randomIndex, left);
        int bv = a[left];   // 每次取基准值为当前排序序列的第一个元素
        // 使用双边快排实现
        int i = left + 1;
        int j = right;
        // i小于j的时候直接开始找
        while (i <= j) {
            // 从左往右找，找到第一个比基准值大的元素(这里需要等于)
            while (i <= j && a[i] <= bv) {
                i++;
            }
            // 从右往左找，使用while循环，直到找到一个比基准值小的或等于的元素
            while (i <= j && a[j] >= bv) {
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


    // 三向排序
    public static void quickSort(int[] a, int left, int right) {
        // 小数据可以使用插入排序，优化性能
        if (right - left <= 16) {
            insertSort(a, left, right);
            return;
        }

        // 递归出口，注意是left>=right，因为p为0的情况下就会如果相等就会爆栈
        if (left >= right) {
            return;
        }
        // 处理逆序数组
        int randomIndex = ThreadLocalRandom.current().nextInt(right - left + 1) + left;
        swap(a, randomIndex, left);
        // 处理重复元素
        int lt = left, gt = right;  // 声明两个指针
        int pivot = a[left];    // 初始化基准点
        int i = left;   // 初始化指针
        // 6 4 3 2 8 5
        // i=0 gt=5 pivot=6 i=1 4<6 a[1]=a[0] a[0]=a[1] 4 6 3 2 8 5 i=2
        while (i <= gt) {
            // 小于基准点的时候更新lt的索引，并且交换原始数组的元素。更新i指针，
            // 根据上面的过程可以看到，a[lt]一定是已经判断过了（lt<=i），所以可以更新i指针。
            if (a[i] < pivot) {
                swap(a, lt++, i++);
                //  大于基准点的时候仅仅交换一下位置，不要更新i指针，因为当前交换的元素a[gt]还没有判断呢
            } else if (a[i] > pivot) {
                swap(a, i, gt--);
            }
            // 跟基准点相等的元素就直接跳过，不再处理了
            else {
                i++;
            }
        }
        quickSort(a, left, lt - 1);  // 基准点左边的元素
        quickSort(a, gt + 1, right); // 基准点右边的元素
    }

    /*
    * 插入排序的思想是假定第一个元素是有序的，跟左边的有序数组进行比较，从最左边的最右边元素的索引开始遍历，如果满足条件就右移
    * （这个时候要排序的元素已经把位置空出来了，不用怕）。因此遍历完毕左边的有序数组（如果需要的话），元素就插入到了有序队列中
    * 循环进行遍历右边的无序数组
    * */
    private static void insertSort(int[] arr, int left, int right) {
        for (int i = left + 1; i <= right; i++) {
            int key = arr[i]; // 定义当前处理元素
            int j = i - 1;
            // 元素向后扫描
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];    // 空出插入位置
                j--;
            }
            // 找到插入位置赋值
            arr[j + 1] = key;
        }
    }


    // 1 2 1=temp
    // a[1]=temp
    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private static void sort(int[] a) {
        // Arrays.sort(a);
        quickSort(a, 0, a.length - 1);
    }

    public static void main(String[] args) {
        int[] a = {4, 2, 6, 5, 1};
        sort(a);
        System.out.println(Arrays.toString(a));
    }


}
