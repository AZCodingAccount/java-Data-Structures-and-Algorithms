package com.zh.codetop;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-11-07 00:10
 * @description: 字符串相加
 **/
public class AddStrings {
    public String addStrings(String num1, String num2) {
        int m = num1.length(), n = num2.length();
        int idx = 0, carry = 0;
        StringBuilder sb = new StringBuilder();
        while (idx < m || idx < n) {
            int idx1 = m - idx - 1, idx2 = n - idx - 1;
            int b1 = idx1 < 0 ? 0 : num1.charAt(idx1) - '0';
            int b2 = idx2 < 0 ? 0 : num2.charAt(idx2) - '0';
            int num = b1 + b2 + carry;
            if (num >= 10) {
                num %= 10;
                carry = 1;
            } else {
                carry = 0;
            }
            sb.append(num);
            idx++;
        }
        if (carry == 1) sb.append(carry);
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(new AddStrings().addStrings("456", "77"));
    }
}
