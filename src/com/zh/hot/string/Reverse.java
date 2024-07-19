package com.zh.hot.string;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-07-19 13:47
 * @description: 整数反转—lc7
 **/
public class Reverse {
    public int reverse(int x) {
        String str = String.valueOf(x);
        int res = 0, carry = 1;
        for (int i = str.length() - 1; i >= 0; i--) {
            if (str.charAt(i) == '-') {
                carry = -1;
                continue;
            }
            int digit = str.charAt(i) - '0';
            // 判断越界 219089 21908
            if (res > (Integer.MAX_VALUE - digit) / 10) {
                return 0;
            }
            res = digit + res * 10;
        }
        return res * carry;
    }


}
