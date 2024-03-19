package com.zh.algorithm.dp;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-03-10 17:14
 * @description: 不同路径——力扣62题
 **/
public class UniquePath {
    /*
        一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
        机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
        问总共有多少条不同的路径？跟走台阶差不多

        递归思想，自顶向上   两条路，一个往右，一个往下走 到头返回1。这个是(1,1)=(1,2)+(2,1)   (1,2)=(1,3)+(2,1)   以此类推
        DP思想，自底向下，扎根基层。慢慢的从(1,1)——>(m,n) 求出每个格子的路径个数
     */

    public int uniquePaths(int m, int n) {

        int x = 1, y = 1;   // 当前的坐标
        int[][] memory = new int[m + 1][n + 1]; // 记忆数组
        // return rec(m, n, x, y, memory);

        return dp(m, n);
    }

    /*
        dp求解
     */
    private static int dp(int m, int n) {
        // 还有一个解法是当前格子为左边+上边的格子数
        int[][] dp = new int[m + 1][n + 1];     // 实际索引0-m
        // 从1开始，0-m 均为0  0-n均为0，代表给格子套了一层
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (i == 1 && j == 1) {
                    dp[1][1] = 1;   // 第一个格子
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }

        return dp[m][n];
    }

    /*
            记忆法优化递归
     */
    private int rec(int m, int n, int x, int y, int[][] memory) {
        /*
                四种情况，往下走不了了，往右走不了了，走到头了，还可以走
         */
        int sum = 0;
        if (x == m && y == n) {
            memory[x][y] = 1;
            return 1;
        } else if (x == m) {  // 只能往下走
            if (memory[x][y + 1] != 0) {
                sum += memory[x][y + 1];
            } else {
                memory[x][y + 1] = rec(m, n, x, y + 1, memory);
                sum += memory[x][y + 1];
            }
        } else if (y == n) {  // 只能往右走
            if (memory[x + 1][y] != 0) {
                sum += memory[x][y + 1];
            } else {
                memory[x + 1][y] = rec(m, n, x + 1, y, memory);
                sum += memory[x + 1][y];
            }
        } else {  // 都可以走
            if (memory[x][y + 1] != 0) {
                sum += memory[x][y + 1];
            } else {
                memory[x][y + 1] = rec(m, n, x, y + 1, memory);
                sum += memory[x][y + 1];
            }
            if (memory[x + 1][y] != 0) {
                sum += memory[x][y + 1];
            } else {
                memory[x + 1][y] = rec(m, n, x + 1, y, memory);
                sum += memory[x + 1][y];
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new UniquePath().uniquePaths(3, 7));
    }
}
