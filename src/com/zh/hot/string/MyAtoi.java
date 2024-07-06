package com.zh.hot.string;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-07-06 13:41
 * @description:
 **/
public class MyAtoi {
    public int myAtoi(String s) {
        // 1:读入字符串并丢弃前导空格
        int start = 0, length = s.length();
        while (start < length && s.charAt(start) == ' ') start++;
        if (start == length) return 0;

        // 2:检查数字符号
        int sign = 1;
        if (s.charAt(start) == '-') {
            sign = -1;
            start++;
        } else if (s.charAt(start) == '+') {
            start++;
        }

        // 3：拼接整数
        long res = 0;
        // int res=0;
        while (start < length && s.charAt(start) >= '0' && s.charAt(start) <= '9') {
            int digit = s.charAt(start) - '0';
            /*溢出判断，下面公式根据res的计算公式推出来的，把res赋值为Integer.MAX_VALUE
            如果是整数，比如2147483646，并不会进来
            如果是负数，且绝对值2147483647，也不会进来
            只有s=2147483648。214748364 > 2147483647-8=2147483639/10=214748363，才进去 */
            // if (res > (Integer.MAX_VALUE - digit) / 10) {
            //     return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            // }
            res = (res * 10) + digit;
            // 溢出判断，也不能相等，相等负数溢出会判错
            if (res > Integer.MAX_VALUE) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            start++;
        }
        return (int) (res * sign);
    }

    public static void main(String[] args) {
    }
}
