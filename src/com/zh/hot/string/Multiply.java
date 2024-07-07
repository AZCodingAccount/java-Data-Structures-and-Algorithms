package com.zh.hot.string;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-07-07 15:54
 * @description: 字符串相乘
 **/
public class Multiply {
    public String multiply(String num1, String num2) {
        int m = num1.length(), n = num2.length();
        int[] chs = new int[m + n]; // 最大值就是m+n，可能填不满
        for (int i = 0; i < m; i++) {   // 从后向前
            for (int j = 0; j < n; j++) {   // 从后向前
                int a = num1.charAt(m - i - 1) - '0';
                int b = num2.charAt(n - j - 1) - '0';
                chs[i + j] += a * b;    // 注意这里存储的是反过来的，chs[0]存储的是结果的最后一位
            }
        }
        // 此时每个字符数组存的是没有经过进位的值，比如 34、420现在需要进位
        int carry = 0;
        for (int i = 0; i < chs.length; i++) {
            chs[i] += carry;
            carry = chs[i] / 10;
            chs[i] = chs[i] % 10;
        }
        // 此时数字数组都满足条件了，这个时候收集结果，小心没有填满数字数组的情况，比如2*3=6，但是此时存储的是[0,6]
        StringBuilder sb = new StringBuilder();
        for (int i = chs.length - 1; i >= 0; i--) {
            if (sb.isEmpty() && chs[i] == 0 && i != 0) continue; // 最后0*0的情况被忽视了，因此兼容一下
            sb.append(chs[i]);
        }
        return sb.toString();
    }
}
