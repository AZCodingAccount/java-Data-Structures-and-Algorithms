package com.zh.job.greedy;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-06-23 21:36
 * @description: 划分字母区间—lc763
 **/
public class PartitionLabels {
    /*
        很简单的一个贪心思路，就是每次尽量能不能只装一个元素，遍历过程中如果出现其他元素，更新需要遍历的最远位置。然后遍历到终点。
        时间复杂度是N^2，使用哈希表可以优化一下
     */
    public List<Integer> partitionLabels(String s) {
        char[] chs = s.toCharArray();
        List<Integer> res = new ArrayList<>();
        int[] cache = new int[128];
        int left = 0;
        int right = -2;
        for (int i = 0; i < chs.length; i++) {
            if (i-1 == right) {   // 找到了一个片段
                res.add(right - left + 1);
                left = i;
            }
            // 寻找这个元素的右索引
            int j;
            int newRight = i;
            if (cache[chs[i]] == 0) {   // 没有命中缓存，循环找
                j = i + 1;
                while (j < chs.length) {
                    if (chs[j] == chs[i]) {
                        newRight = j-1;
                    }
                    j++;
                }
            }
            right = Math.max(newRight, right);  // 更新右节点
            cache[chs[i]] = newRight;  // 缓存当前字符的右索引
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(new PartitionLabels().partitionLabels("caedbdedda"));
    }
}
