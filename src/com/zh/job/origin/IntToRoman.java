package com.zh.job.origin;

import java.util.LinkedHashMap;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-03-20 19:22
 * @description: 整数转罗马数字——leetcode12
 **/
public class IntToRoman {
    /*
            假设有一个数字92,92=90+2，思路是贪心，直接查表即可

     */

    public String intToRoman(int num) {
        LinkedHashMap<Integer, String> map = new LinkedHashMap<>(); // 存储映射
        // 初始化
        map.put(1000, "M");
        map.put(900, "CM");
        map.put(500, "D");
        map.put(400, "CD");
        map.put(100, "C");
        map.put(90, "XC");
        map.put(50, "L");
        map.put(40, "XL");
        map.put(10, "X");
        map.put(9, "IX");
        map.put(5, "V");
        map.put(4, "IV");
        map.put(1, "I");

        StringBuilder res = new StringBuilder();
        // 直接遍历map，顺序就是从大到小
        for (Integer n : map.keySet()) {
            // 对这个量级的进行处理
            while (num >= n) {
                num -= n;
                res.append(map.get(n));
            }
            if (num == 0) {
                break;
            }
            // 如果小于这个量级的，什么也不做
        }
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(new IntToRoman().intToRoman(5));
    }
}
