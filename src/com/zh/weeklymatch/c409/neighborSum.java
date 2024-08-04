package com.zh.weeklymatch.c409;

class neighborSum {
    int[][] grid;

    public neighborSum(int[][] grid) {
        this.grid = grid;
    }

    public int adjacentSum(int value) {
        int[] idx = find(value);
        int m = grid.length;
        int n = grid[0].length;
        int row = idx[0], col = idx[1];
        int res = 0;
        if (row - 1 >= 0) res += grid[row - 1][col];
        if (row + 1 < m) res += grid[row + 1][col];
        if (col - 1 >= 0) res += grid[row][col - 1];
        if (col + 1 < n) res += grid[row][col + 1];
        return res;
    }

    private int[] find(int value) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (value == grid[i][j]) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1};
    }

    public int diagonalSum(int value) {
        int[] idx = find(value);
        int m = grid.length;
        int n = grid[0].length;
        int row = idx[0], col = idx[1];
        int res = 0;
        if (row - 1 >= 0 && col - 1 >= 0) res += grid[row - 1][col - 1];
        if (row - 1 >= 0 && col + 1 < n) res += grid[row - 1][col + 1];
        if (row + 1 < m && col - 1 >= 0) res += grid[row + 1][col - 1];
        if (row + 1 < m && col + 1 < n) res += grid[row + 1][col + 1];
        return res;
    }
}