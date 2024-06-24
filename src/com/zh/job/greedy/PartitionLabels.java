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

        Carl哥的写法：比我的代码更简单：
        1：首先遍历一遍数组，将每个字母出现的最远距离缓存起来。O(n)
        2：再遍历一遍这个数组，不停更新left和right的值，left和right就是左闭右闭了。不需要处理第一个的特殊情况，也不需要处理最后一个
     */
    public List<Integer> partitionLabels(String s) {
        char[] chs = s.toCharArray();
        List<Integer> res = new ArrayList<>();
        int[] cache = new int[128];
        int left = 0;
        int right = -2;
        // 注意这里的left和right是包左不包右
        for (int i = 0; i < chs.length; i++) {
            if (i == right) {   // 找到了一个片段
                res.add(right - left);
                left = i;
            }
            // 寻找这个元素的右索引
            int j;      // 循环变量
            int newRight = i + 1;   // 新元素
            if (cache[chs[i]] == 0) {   // 没有命中缓存，循环找
                j = i + 1;
                while (j < chs.length) {
                    if (chs[j] == chs[i]) {
                        newRight = j + 1;   // 包左不包右
                    }
                    j++;
                }
            } else {
                newRight = cache[chs[i]];
            }
            right = Math.max(newRight, right);  // 更新右节点
            cache[chs[i]] = newRight;  // 缓存当前字符的右索引
        }
        res.add(right - left);  // 最后收集一下结果，因为最后一个没有收集到

        return res;
    }

    public static void main(String[] args) {
        System.out.println(new PartitionLabels().partitionLabels("ababcbacadefegdehijhklij"));
        System.out.println(new PartitionLabels().partitionLabels("caedbdedda"));
    }
}
