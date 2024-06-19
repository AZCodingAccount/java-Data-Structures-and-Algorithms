package com.zh.job.greedy;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-06-19 21:40
 * @description: 摆动序列—lc376
 **/
public class WiggleMaxLength {
    /*
            妈妈告诉我们，子序列和子串是不一样的，子序列可以跳着来，不用连续。这里就是找一个上下最多的。
        因此贪心策略是删除上坡或者下坡的元素，让g点最多即可。最后的值是2*n+1。关心如何判断是上下坡还是g点即可
     */

    public int wiggleMaxLength(int[] nums) {
        if (nums.length == 1) {
            return 1;
        }
        int top = 0;    // 坡顶元素个数，不要记录上下坡的元素，那样排除不了单调递增或递减的
        boolean isRepeat = true;
        int num = nums[0];    // 基准点，辅助判断数组是否有重复元素
        for (int i = 1; i < nums.length; i++) {
            if (num != nums[i]) {
                isRepeat = false;   // 数组中有不重复的元素
            }
            if (i < nums.length - 1) {
                if ((nums[i] > nums[i - 1] && nums[i] > nums[i + 1])
                        || (nums[i] < nums[i - 1] && nums[i] < nums[i + 1])) {
                    top++;
                }
            }
        }
        // 题中说两个不同的认定摆动序列为2，这个特殊处理一下
        if (top == 0) {
            if (!isRepeat) {
                return 2;
            }
            return 1;
        }
        return top + 2;
    }

    public static void main(String[] args) {
        System.out.println(new WiggleMaxLength().wiggleMaxLength(new int[]{2, 2}));
    }
}
