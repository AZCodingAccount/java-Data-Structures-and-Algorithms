package com.zh.weeklymatch.dc136;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-08-03 22:43
 * @description:
 **/
public class MinFlips {
    public int minFlips(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int row = 0, col = 0;
        // 每行
        for (int i = 0; i < m; i++) {
            row += flip(grid[i]);
        }
        // 每列
        for (int i = 0; i < n; i++) {
            int[] cols = new int[m];
            for (int j = 0; j < m; j++) {
                cols[j] = grid[j][i];
            }
            col += flip(cols);
        }
        return Math.min(row, col);
    }

    private int flip(int[] row) {
        int left = 0, right = row.length - 1, flips = 0;
        while (left <= right) {
            if (row[left] != row[right]) {
                flips++;
            }
            left++;
            right--;
        }
        return flips;
    }
}
