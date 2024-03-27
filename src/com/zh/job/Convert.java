package com.zh.job;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-03-27 13:37
 * @description: Z字形变换——leetcode6
 **/
public class Convert {
    /*
            可以定义一个nums数组，数组里面存储list，数组长度为numRows。遍历完毕以后输出数组即可。
        Z字形的规律定义一个指针，根据该往哪走修改指针的值
        i % numRows+1，说明  行数为3时
        0%4=0   往下走    p++
        1%4=1   往下走    p++
        2%4=2   往上走    p--
        3%4=3   往上走    p--
        4%4=0   往下走    p++

        P           C
        C       Y   M
        A   T       Z
        Y           R


     */
    public String convert(String s, int numRows) {
        if (numRows == 0) return s;
        List<Character>[] nums = new ArrayList[numRows];

        for (int i = 0; i < nums.length; i++) {
            nums[i] = new ArrayList<>();
        }

        int p = 0;
        boolean flag = true;    // true代表向下+、false代表向右减
        char[] chs = s.toCharArray();
        for (char ch : chs) {
            nums[p].add(ch);
            // 更新方向
            if (p == numRows - 1) {
                flag = false;
            } else if (p == 0) {
                flag = true;
            }
            // 更新指针
            if (flag) {
                p++;
            } else {
                p--;
            }
        }
        // 拼接字符串结果
        StringBuilder sb = new StringBuilder();
        for (List<Character> num : nums) {
            for (Character c : num) {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Convert().convert("AB", 1));
    }
}
