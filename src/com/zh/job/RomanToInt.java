package com.zh.job;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-03-20 19:04
 * @description: 罗马数字转整数——leetcode13
 **/
public class RomanToInt {

    /*
        罗马数字转整数，不需要枚举特殊情况，这些都可以转换为处理左边的数字
     */
    public int romanToInt(String s) {
        char[] chs = s.toCharArray();
        int res = 0;
        for (int i = 0; i < chs.length - 1; i++) {
            if (mapToInt(chs[i]) >= mapToInt(chs[i + 1])) {
                // 说明是正常的
                res += mapToInt(chs[i]);
            } else {
                // 特殊情况，比如 IV
                res -= mapToInt(chs[i]);
            }
        }
        // 处理最后一个
        res += mapToInt(chs[chs.length - 1]);
        return res;
    }

    private int mapToInt(char ch) {
        return switch (ch) {
            case 'I' -> 1;
            case 'V' -> 5;
            case 'X' -> 10;
            case 'L' -> 50;
            case 'C' -> 100;
            case 'D' -> 500;
            case 'M' -> 1000;
            default -> 0;
        };
    }

    public static void main(String[] args) {
        System.out.println(new RomanToInt().romanToInt("IV"));
    }
}
