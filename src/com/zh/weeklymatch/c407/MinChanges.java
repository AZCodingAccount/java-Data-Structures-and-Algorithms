package com.zh.weeklymatch.c407;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-07-21 10:39
 * @description: 使两个整数相等的位更改次数—第一题
 **/
public class MinChanges {
    // 1110     1101
    // 1100     0011
    public int minChanges(int n, int k) {
        if (n < k || Integer.bitCount(n) < Integer.bitCount(k)) {
            return -1;
        }

        // 计算 n 和 k 的二进制表示
        String binN = Integer.toBinaryString(n);
        String binK = Integer.toBinaryString(k);
        // 补全 k
        while (binK.length() < binN.length()) {
            binK = "0".concat(binK);
        }
        // 统计需要改变的次数
        int res = 0;
        for (int i = 0; i < binN.length(); i++) {
            if (binN.charAt(i) == '0' && binK.charAt(i) == '1') {
                return -1;
            }

            if (binN.charAt(i) == '1' && binK.charAt(i) == '0') {
                res += 1;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(new MinChanges().minChanges(3, 12));
    }
}
