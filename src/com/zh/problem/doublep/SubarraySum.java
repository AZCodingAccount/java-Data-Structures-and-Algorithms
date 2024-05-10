package com.zh.problem.doublep;

import java.util.HashMap;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-05-02 23:19
 * @description: 和为K的子数组—lc560
 **/
public class SubarraySum {
    /*
        使用双指针解法，快指针和慢指针之间维护一个数组，数组sum>k，左指针移动，sum<k，右指针移动，=k，
        （上面解法pass，因为存在负值）
             使用前缀和+哈希表,思想是这样的(跟两数之和类似)，要求和为k，那么分解成sum和sum-k两部分，
         之前的和为sum-k的再拼接上这次的，就是满足条件的count
            举例来说，[1,1,1,2] k=2 ,当前缀和为2时，就是前两个元素，那么满足条件的就是map(0)=1  count+=1，更新map(2)=1
        前缀和为3时，就是2-3个元素，满足条件的就是map(1)=1，count+=1,更新map(3)=1
     */
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int preSum = 0, count = 0;
        map.put(0, 1);  // 初始化map
        for (int num : nums) {
            preSum += num;
            if (map.get(preSum - k) != null) {  // 有值，可以更新count
                count += map.get(preSum - k);
            }
            // 没有值或者有值，都更新map里面的缓存
            map.put(preSum, map.getOrDefault(preSum, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new SubarraySum().subarraySum(new int[]{1, 1, 1}, 2));
    }
}
