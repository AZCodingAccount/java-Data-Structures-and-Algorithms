package com.zh.hot.matrix;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-07-21 18:24
 * @description: 矩阵快速幂—lcr126斐波那契数
 **/
public class Fib {

    static int MOD = 1000000007;

    public int fib(int n) {
        if (n < 2) return n;
        // 矩阵快速幂
        int pow = n - 1;
        return cal(pow);
    }

    private int cal(int pow) {
        // int[][] mat = new int[][]{{1, 1}, {1, 0}};
        int[][] mat = new int[][]{{0, 1}, {1, 1}};  // 这种方式求的参数是(F(n),F(n+1))这种
        int[][] res = new int[][]{{1, 0}, {0, 1}};
        while (pow > 0) {
            if ((pow & 1) == 1) { // 奇数次幂，只在循环开始和pow降到1的时候乘
                res = mul(res, mat);
            }
            pow = pow >> 1; // /2;
            mat = mul(mat, mat);
        }
        // return res[0][0];   // 两行两列的第一个数
        return res[1][1];   // 最后的矩阵*(0,1)，得到的最后一个才是要求的数字，可以直接返回两行两列的第二个数
    }

    private int[][] mul(int[][] mat1, int[][] mat2) {
        /*
            1  7     2   5
            3  8     4   6
         */
        int[][] mat3 = new int[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                mat3[i][j] = (int) (((long) mat1[i][0] * mat2[0][j] % MOD + (long) mat1[i][1] * mat2[1][j] % MOD) % MOD);
            }
        }
        return mat3;
    }
}
