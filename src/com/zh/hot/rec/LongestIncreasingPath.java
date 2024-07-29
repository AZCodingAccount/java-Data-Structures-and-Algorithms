package com.zh.hot.rec;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-07-29 20:21
 * @description: 矩阵中的最长递增路径—lc329
 **/
public class LongestIncreasingPath {
    int res = 0;
    int[] dx = new int[]{0, 0, -1, 1}, dy = new int[]{1, -1, 0, 0};

    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] memo = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res = Math.max(dfs(matrix, memo, i, j), res);
            }
        }
        return res;
    }

    private int dfs(int[][] matrix, int[][] memo, int i, int j) {
        if (memo[i][j] != 0) return memo[i][j];
        int m = matrix.length, n = matrix[0].length;
        int max = 1;
        for (int k = 0; k < 4; k++) {
            int x = i + dx[k], y = j + dy[k];
            if (x >= 0 && x < m && y >= 0 && y < n && matrix[x][y] > matrix[i][j]) {
                max = Math.max(max, dfs(matrix, memo, x, y) + 1);   // 看看去哪个方向找更好
            }
        }
        memo[i][j] = max;   // 缓存计算的结果
        return max; // 可以存在上下左右都没有比当前元素大的情况，默认为1；
    }

    public static void main(String[] args) {
        System.out.println(new LongestIncreasingPath().longestIncreasingPath(new int[][]{{9, 9, 4}, {6, 6, 8}, {2, 1, 1}}));
    }
}
