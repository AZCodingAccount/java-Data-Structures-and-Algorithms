package com.zh.weeklymatch.dc136;

import java.util.Arrays;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-08-03 22:43
 * @description:
 **/
public class MinFlips2 {
    int add1cnt = 0;

    public int minFlips(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int row = 0, col = 0;
        int row1 = 0, col1 = 0;
        // 每行
        for (int i = 0; i < m; i++) {
            row += flip(grid[i]);
        }
        row1 = add1cnt;
        add1cnt = 0;
        // 每列
        for (int i = 0; i < n; i++) {
            int[] cols = new int[m];
            for (int j = 0; j < m; j++) {
                cols[j] = grid[j][i];
            }
            col += flip(cols);
        }
        col1 = add1cnt;
        int cnt;
        // 看奇偶
        int res = 0;
        cnt = cnt1(grid) + col1;
        int l = cnt % 4;    // 还剩下多少缺口
        if (l == 1 || l == 3) res = col;
        if (col == 0) res = l;
        if (l == 2) res = col + 2;


        cnt = cnt1(grid) + row1;
        l = cnt % 4;    // 还剩下多少缺口
        if (l == 1 || l == 3) res = Math.min(res, row);
        if (row == 0) res = Math.min(l, res); // 帮助
        if (l == 2) res = Math.min(res, row + 2); // 多换两次

        return res;

    }

    private int cnt1(int[][] grid) {
        int cnt = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    private int flip(int[] row) {
        int left = 0, right = row.length - 1, flips = 0;
        // 统一让0先变成1
        while (left <= right) {
            if (row[left] != row[right]) {
                flips++;
                add1cnt++;
            }
            left++;
            right--;
        }
        return flips;
    }

    public static void main(String[] args) {
        System.out.println(new MinFlips2().minFlips(new int[][]{{0, 0, 1}, {1, 1, 0}, {1, 1, 1}, {0, 1, 1}}));
    }
}
