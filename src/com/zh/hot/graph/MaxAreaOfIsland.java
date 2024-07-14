package com.zh.hot.graph;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-07-14 17:04
 * @description: 岛屿的最大面积—lc695
 **/
public class MaxAreaOfIsland {
    /*
        访问过的置为0即可
     */
    int res = 0;
    int landCnt = 0;
    int[] dx = new int[]{-1, 1, 0, 0};
    int[] dy = new int[]{0, 0, 1, -1};

    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != 0) {
                    landCnt = 0;
                    flood(grid, m, n, i, j);
                    res = Math.max(landCnt, res);
                }
            }
        }
        return res;
    }

    private void flood(int[][] grid, int m, int n, int i, int j) {
        // 越界或者遍历到的不是1，退出
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == 0) return;
        landCnt++;
        grid[i][j] = 0;
        // 四面八方延伸
        for (int k = 0; k < 4; k++) {
            int x = i + dx[k], y = j + dy[k];
            flood(grid, m, n, x, y);
        }
    }
}
