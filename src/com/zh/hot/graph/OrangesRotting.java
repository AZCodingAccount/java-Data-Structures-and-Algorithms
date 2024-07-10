package com.zh.hot.graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-07-10 12:58
 * @description: 腐烂的橘子—lc994
 **/
public class OrangesRotting {
    public int orangesRotting(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int res = 0, fresh = 0; // fresh用来判断是否还可以继续腐烂（传播）
        Queue<int[]> queue = new LinkedList<>();    // 这个队列存储的是当前分钟的遍历次数
        // 第一次遍历入队感染橘子并更新新鲜橘子个数
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) queue.offer(new int[]{i, j});
                else if (grid[i][j] == 1) fresh++;
            }
        }
        // 接下来不停感染，直到全部都是新鲜的橘子或者上一轮没有新的感染者加进来
        while (fresh > 0 && !queue.isEmpty()) {
            int size = queue.size();
            // 感染本轮的
            for (int k = 0; k < size; k++) {
                int[] cell = queue.poll();
                int[] dx = new int[]{-1, 1, 0, 0}, dy = new int[]{0, 0, -1, 1};
                for (int l = 0; l < 4; l++) {
                    int i = dx[l] + cell[0], j = dy[l] + cell[1];
                    if (i >= 0 && i < m && j >= 0 && j < n && grid[i][j] == 1) {
                        grid[i][j] = 2;
                        queue.offer(new int[]{i, j});
                        fresh--; // 新鲜橘子减少
                    }
                }
            }
            res++;
        }
        return fresh > 0 ? -1 : res;
    }
}
