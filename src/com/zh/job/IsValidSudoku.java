package com.zh.job;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-03-28 13:50
 * @description: 有效的数独——leetcode36
 **/
public class IsValidSudoku {

    /*
            解数独采用回溯，而判断数独是否有效只需要判断每一个位置的有效性即可，解法有两个。
        1: 暴力求解，对每个点都进行 行 列  区域的合法性判断，这样复杂度太高。81*9*9*9
        2：定义三个数组，每个数组负责存储当前位置的元素，发现当前位置的值大于0，不是数独。需要注意的是数组存储的是1-9出现的个数
     */

    public boolean isValidSudoku(char[][] board) {
        int[][] rows = new int[9][9];           // 行
        int[][] cols = new int[9][9];           // 列
        int[][][] areas = new int[3][3][9];     // 区域
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] != '.') {
                    // 行
                    if (rows[i][board[i][j] - '0' - 1] == 0) {
                        rows[i][board[i][j] - '0' - 1]++;
                    } else {
                        return false;
                    }
                    // 列
                    if (cols[j][board[i][j] - '0' - 1] == 0) {
                        cols[j][board[i][j] - '0' - 1]++;
                    } else {
                        return false;
                    }
                    // 区域
                    if (areas[i / 3][j / 3][board[i][j] - '0' - 1] == 0) {
                        areas[i / 3][j / 3][board[i][j] - '0' - 1]++;
                    } else {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new IsValidSudoku().isValidSudoku(new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        }));
    }
}
