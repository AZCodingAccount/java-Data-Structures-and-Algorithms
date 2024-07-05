package com.zh.hot.string;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-07-05 17:24
 * @description: 比较版本号—lc165
 **/
public class CompareVersion {
    public int compareVersion(String version1, String version2) {
        int p1 = 0, p2 = 0;
        int m = version1.length(), n = version2.length();
        while (p1 < m || p2 < n) {
            int num1 = 0, num2 = 0; // 两个版本号
            while (p1 < m && version1.charAt(p1++) != '.') {
                num1 = 10 * num1 + (version1.charAt(p1++) - '0');
            }
            p1++;   // 跳过.方便下一轮比较
            while (p2 < n && version2.charAt(p2) != '.') {
                num2 = 10 * num2 + (version2.charAt(p2++) - '0');
            }
            p2++;
            if (num1 > num2) return 1;  // 后面的再大也不顶用了
            if (num1 < num2) return -1;     // 后面的再小也不顶用了
            // num1=num2进入下一轮比较
        }
        return 0;
    }
}
