package com.zh.algorithm.sort;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-03-07 11:30
 * @description: 根据每个值的频率排序—leetcode1636
 **/
public class FrequencySort {
    /*
            记录数字中每个数和它对应的出现频率，一个想法是通过哈希表记录，但是记录了以后没办法在O(1)的概率取出最大值。另一个想法是改造基数排序
            再根据第一轮基数排序的数组自定义排序函数，根据频率（即第一轮数组值）排序即可
     */

    public int[] frequencySort(int[] nums) {
        int[] arr = new int[201];
        for (int num : nums) {
            arr[num + 100]++;   // 如果是max-min的情况下，应该是num-min，这里因为数据量小直接定死了
        }
        // 自定义排序函数
        Integer[] boxNums = Arrays.stream(nums).boxed().toArray(Integer[]::new);
        Arrays.sort(boxNums, (o1, o2) -> {
            // o1、o2为原数组的值
            // 按照频率升序、频率相同按照值降序
            if (arr[o1 + 100] > arr[o2 + 100]) {
                // o1应该在后面
                return 1;
            } else if (arr[o1 + 100] < arr[o2 + 100]) {
                // o1应该在前面
                return -1;
            } else {
                return o2 - o1;
            }
        });
        // 包装数组拷贝回去
        nums = Arrays.stream(boxNums).mapToInt(Integer::intValue).toArray();
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 2, 2, 2, 3};
        System.out.println(Arrays.toString(new FrequencySort().frequencySort(nums)));
    }

}
