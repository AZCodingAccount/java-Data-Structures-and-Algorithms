package com.zh.job.array;

import java.util.Random;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-07-28 16:25
 * @description: 打乱数组—lc394
 **/
public class ShuffleArray {
    int[] nums;
    int[] shuffle;
    Random random;

    public ShuffleArray(int[] nums) {
        this.nums = nums;
        random = new Random();
    }

    public int[] reset() {
        return nums;
    }

    public int[] shuffle() {
        shuffle = nums.clone();
        for (int i = 0; i < nums.length - 1; i++) {
            int idx = i + random.nextInt(nums.length - i);
            int temp = shuffle[i];
            shuffle[i] = shuffle[idx];
            shuffle[idx] = temp;
        }
        return shuffle;
    }
}
