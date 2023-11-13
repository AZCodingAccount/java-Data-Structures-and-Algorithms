package com.zh.algorithm.recursive;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2023-11-13 14:13
 * @description: 杨辉三角的递归实现以及备忘录法优化（当然，双层for直接实现也可以）
 **/
public class YangHuiTriangle {


    /**
     * @param i 行号
     * @param j 列号
     * @return int 当前行列的值
     * @author AlbertZhang
     * @description 计算杨辉三角中指定位置的值
     * @date 2023-11-13 14:24
     **/
    public static int yangHuiTriangle(int i, int j) {
        // 杨辉三角的两个约束条件
        if (j == 1 || i == j) {
            return 1;
        }
        // 如果不是特殊情况，那么就是返回上一行的第j个元素和第j-1个元素的和
        return yangHuiTriangle(i - 1, j) + yangHuiTriangle(i - 1, j - 1);
    }

    /**
     * @param n 杨辉三角的层数
     * @return void
     * @author AlbertZhang
     * @description 打印杨辉三角的值
     * @date 2023-11-13 14:40
     **/
    public static void print(int n) {
        for (int i = 0; i < n; i++) {
            // 给每一行打印空格
            printSpace(n, i + 1);
            for (int j = 0; j <= i; j++) {
                System.out.printf("%-4d", yangHuiTriangle(i + 1, j + 1));
            }
            System.out.println();
        }
    }

    /**
     * @param n    一共的层数
     * @param line 当前行（以第1行为开头）
     * @return void
     * @author AlbertZhang
     * @description 打印空格
     * @date 2023-11-13 14:53
     **/
    public static void printSpace(int n, int line) {
        // 第n行0个，第n-1行2个...第1行(n-line)*2
        for (int i = 0; i < (n - line) * 2; i++) {
            System.out.print(" ");
        }
    }

    /**
     * @param i      行号
     * @param j      列号
     * @param memory 记忆数组
     * @return int
     * @author AlbertZhang
     * @description 记忆法优化递归
     * @date 2023-11-13 15:12
     **/
    public static int yangHuiTriangle2(int i, int j, int[][] memory) {
        // 这里需要注意的是我传进来的是行号和列号，但是memory那里还是使用的从0开始的下标
        if (j == 1 || i == j) {
            memory[i - 1][j - 1] = 1;
            return 1;
        }
        if (memory[i - 1][j - 1] != 0) {
            return memory[i - 1][j - 1];
        }
        // 如果不是特殊情况，那么就是返回上一行的第j个元素和第j-1个元素的和
        return yangHuiTriangle(i - 1, j) + yangHuiTriangle(i - 1, j - 1);
    }

    /**
     * @param n 当前打印的层数
     * @return void
     * @author AlbertZhang
     * @description 记忆法优化（不优化之前是2^n量级的，优化后达到n^2）
     * @date 2023-11-13 14:54
     **/
    public static void print2(int n) {
        // 定义一个二维数组用于记录变化
        int[][] memory = new int[n][];
        for (int i = 0; i < n; i++) {
            // 每次进来的时候给每一个二维数组的行赋值长度，就是i+1，注意初始化跟下标不一样（为了节省空间，实际上直接int[n][n]也可以）
            memory[i] = new int[i + 1];
            // 给每一行打印空格（这里的空格打印数根据下面占多少个位数确定，具体得自己调了，）
            printSpace(n, i + 1);
            for (int j = 0; j <= i; j++) {
                System.out.printf("%-4d", yangHuiTriangle2(i + 1, j + 1, memory));
            }
            System.out.println();
        }
    }

    /**
     * <li>测试杨辉三角指定位置值的计算</li>
     * <li>测试杨辉三角的打印</li>
     * <li>测试杨辉三角的性能优化——备忘录法</li>
     */

    public static void main(String[] args) {
        // 测试计算杨辉三角指定位置的值，第3行第二列应该是2
        // System.out.println(yangHuiTriangle(3, 2));
        // 测试打印杨辉三角前n行n列的值
        // print(10);
        // 测试打印杨辉三角前n行n列的值——备忘录法
        print2(5);
    }
}
