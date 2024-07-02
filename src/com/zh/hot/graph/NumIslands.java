package com.zh.hot.graph;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-07-02 16:58
 * @description: 岛屿数量—lc200
 **/
public class NumIslands {
    /*
        使用flood fill算法，遍历每个陆地，碰到不是水的把所有陆地延伸
     */
    int m, n;   // 行和列

    public int numIslands(char[][] grid) {
        int res = 0;

        m = grid.length;
        n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    res++;
                }
            }
        }
        return res;
    }

    private void dfs(char[][] grid, int i, int j) {
        // 碰到边界或者不是陆地
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] != '1') {
            return;
        }
        grid[i][j] = '0';   // 这个节点已经被处理了，防止又重复处理
        // 向四面八方延伸
        dfs(grid, i, j - 1);    // 上
        dfs(grid, i, j + 1);    // 下
        dfs(grid, i - 1, j);    // 左
        dfs(grid, i + 1, j);    // 右
    }
}
