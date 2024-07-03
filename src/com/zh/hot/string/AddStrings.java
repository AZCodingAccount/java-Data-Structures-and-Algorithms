package com.zh.hot.string;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-07-03 17:13
 * @description: 字符串相加—lc415
 **/
public class AddStrings {
    public String addStrings(String num1, String num2) {
        StringBuilder res = new StringBuilder();
        int p1 = num1.length() - 1, p2 = num2.length() - 1, carry = 0;
        while (p1 >= 0 || p2 >= 0 || carry == 1) {
            // 获取两个字符串对应的数字
            int i1 = p1 < 0 ? 0 : num1.charAt(p1) - '0';
            int i2 = p2 < 0 ? 0 : num2.charAt(p2) - '0';
            int sum = i1 + i2 + carry;
            if (sum >= 10) {
                carry = 1;
                sum -= 10;
            } else {
                carry = 0;
            }
            res.append(sum);
            p1--;
            p2--;
        }
        return res.reverse().toString();
    }
}
