package com.zh.hot.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-07-09 16:48
 * @description: 杨辉三角
 **/
public class Generate {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        int[][] dp = new int[numRows + 1][numRows + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= numRows; i++) {
            List<Integer> layer = new ArrayList<>();
            for (int j = 1; j <= i; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1];
                layer.add(dp[i][j]);
            }
            res.add(layer);
        }
        return res;
    }
}
