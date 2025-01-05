package com.zh.codetop;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-11-14 20:19
 * @description:
 **/
public class NumIslands {
    int m, n;

    public int numIslands(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    res++;
                    floodFill(grid, i, j);
                }
            }
        }
        return res;
    }

    // flood fill算法
    private void floodFill(char[][] grid, int i, int j) {
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == '0') return;
        grid[i][j] = '0';
        int[] dx = new int[]{0, 0, -1, 1}, dy = new int[]{1, -1, 0, 0};
        for (int k = 0; k < 4; k++) {
            floodFill(grid, i + dx[k], j + dy[k]);
        }
    }
}
