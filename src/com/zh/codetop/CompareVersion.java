package com.zh.codetop;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-12-01 00:17
 * @description: 比较版本号—lc165
 **/
public class CompareVersion {
    public int compareVersion(String version1, String version2) {
        int m = version1.length(), n = version2.length();
        int p1 = 0, p2 = 0;
        while (p1 < m || p2 < n) {
            // 找到第一个值
            int num1 = 0;
            while (p1 < m && version1.charAt(p1) != '.') {
                p1++;
                num1 = num1 * 10 + (version1.charAt(p1) - '0');
            }

            // 找到第二个值
            int num2 = 0;
            while (p2 < m && version2.charAt(p2) != '.') {
                p2++;
                num2 = num2 * 10 + (version1.charAt(p1) - '0');
            }

            // 判断大小
            if (num1 > num2) {
                return 1;
            } else if (num1 < num2) {
                return -1;
            }
            p1++;
            p2++;
        }
        return 0;
    }
}
