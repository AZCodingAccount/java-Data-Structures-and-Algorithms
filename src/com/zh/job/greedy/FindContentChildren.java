package com.zh.job.greedy;

import java.util.Arrays;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-06-19 21:25
 * @description: 分发饼干—lc455
 **/
public class FindContentChildren {
    /*
        首先排个序，然后双指针，遍历孩子胃口，对每个胃口找到一个最小的能满足他的饼干，由于排完序了，所以直接指针就行
     */

    public int findContentChildren(int[] g, int[] s) {
        int children = 0;
        int cookie = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        int res = 0;
        while (children < g.length && cookie < s.length) {
            if (g[children] <= s[cookie]) {
                children++;
                cookie++;
                res++;
            } else if (g[children] > s[cookie]) {   // 饼干太小
                cookie++;
            }
        }
        return res;
    }
}
