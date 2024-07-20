package com.zh.hot.dp;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-07-20 17:51
 * @description: 圆环会原点—nc311（字节三面高频）
 **/
public class Circle {
    public int circle(int n) {
        // write code here
        int[][] dp = new int[n + 1][10];    // 走i步编号为j

        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < 10; j++) {
                dp[i][j] = (int) ((dp[i - 1][(j - 1 + 10) % 10] + dp[i - 1][(j + 1) % 10]) % (Math.pow(10, 9) + 7));
            }
        }
        return dp[n][0];
    }

    public static void main(String[] args) {
        System.out.println(new Circle().circle(3));
        System.out.println(new Circle().circle(2));
    }
}
