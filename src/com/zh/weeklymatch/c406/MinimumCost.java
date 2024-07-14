package com.zh.weeklymatch.c406;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-07-14 11:12
 * @description: 切蛋糕的最小总开销 I—406周赛第三题
 **/
public class MinimumCost {
    public int minimumCost(int m, int n, int[] horizontalCut, int[] verticalCut) {
        Map<String, Integer> memory = new HashMap<>();
        return rec(m, n, horizontalCut, verticalCut, 0, 0, memory);
    }

    /**
     * 递归函数
     *
     * @param m             长
     * @param n             宽
     * @param horizontalCut 水平花费
     * @param verticalCut   垂直花费
     * @param hStart        水平从何处开始
     * @param vStart        垂直从何处开始
     * @param memory        记忆化，使用哈希表因为需要缓存hStart和vStart
     * @return 当前状态的最小开销
     */
    private int rec(int m, int n, int[] horizontalCut, int[] verticalCut, int hStart, int vStart,
                    Map<String, Integer> memory) {
        if (m == 1 && n == 1) return 0; // 分割到最后了

        String key = m + " " + n + " " + hStart + " " + vStart; // 四元组
        if (memory.containsKey(key)) return memory.get(key);

        int minCost = Integer.MAX_VALUE;

        // 水平切割
        if (m > 1) {
            for (int i = hStart; i < hStart + m - 1; i++) { // 注意这里的m是变的，hStart与m同步
                int totalCost = horizontalCut[i];
                int top = rec(i - hStart + 1, n, horizontalCut, verticalCut, hStart, vStart, memory); // 分割上面
                int bottom = rec(hStart + m - 1 - i, n, horizontalCut, verticalCut, i + 1, vStart, memory); // 分割下面
                totalCost += top + bottom;
                minCost = Math.min(minCost, totalCost);
            }
        }

        // 垂直切割
        if (n > 1) {
            for (int j = vStart; j < vStart + n - 1; j++) {
                int totalCost = verticalCut[j];
                int left = rec(m, j - vStart + 1, horizontalCut, verticalCut, hStart, vStart, memory); // 分割左面
                int right = rec(m, vStart + n - 1 - j, horizontalCut, verticalCut, hStart, j + 1, memory); // 分割右面
                totalCost += left + right;
                minCost = Math.min(minCost, totalCost);
            }
        }

        memory.put(key, minCost); // 缓存结果
        return minCost;
    }

    public static void main(String[] args) {
        System.out.println(new MinimumCost().minimumCost(3, 2, new int[]{1, 3}, new int[]{5}));
    }


}
