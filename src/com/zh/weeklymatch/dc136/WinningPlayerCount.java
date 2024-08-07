package com.zh.weeklymatch.dc136;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-08-03 22:35
 * @description:
 **/
public class WinningPlayerCount {
    public int winningPlayerCount(int n, int[][] pick) {
        int[][] sum = new int[11][11];
        for (int[] p : pick) {
            sum[p[0]][p[1]]++;
        }
        int res = 0;
        // 查找胜利玩家
        for (int i = 0; i < sum.length; i++) {
            for (int j = 0; j < sum[i].length; j++) {
                if (sum[i][j] > i) {
                    res++;
                    break;
                }
            }
        }
        return res;
    }
}
