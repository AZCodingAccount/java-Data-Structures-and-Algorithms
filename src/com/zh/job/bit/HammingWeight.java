package com.zh.job.bit;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-07-31 21:54
 * @description: 位1的个数—lc191
 **/
public class HammingWeight {
    public int hammingWeight(int n) {
        StringBuilder binary = new StringBuilder();
        while (n != 0) {
            int i = n % 2;
            binary.append(i);
            n /= 2;
        }
        int cnt = 0;
        String str = binary.toString();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '1') {
                cnt++;
            }
        }
        return cnt;
    }
}
