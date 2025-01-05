package com.zh.codetop;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-12-01 23:11
 * @description:
 **/
public class MinWindow {
    public String minWindow(String s, String t) {
        int[] arr1 = new int[128];
        int[] arr2 = new int[128];
        int len1 = s.length(), len2 = t.length();
        int diff = 0;
        int left = 0, right = 0, start = 0, len = Integer.MAX_VALUE;
        // 首先统计t
        for (int i = 0; i < len2; i++) {
            if (arr2[t.charAt(i)]++ == 0) {
                diff++;
            }
        }

        // 滑动窗口
        while (right < len1) {
            // 扩大滑动窗口，尝试符合条件
            if (arr2[s.charAt(right)] != 0) {
                if (++arr1[s.charAt(right)] == arr2[s.charAt(right)]) {
                    diff--;
                }
            }
            right++;
            // 如果包含了子串
            while (diff == 0) {
                // 更新结果集
                if (len > (right - left)) {
                    start = left;
                    len = right - left;
                }

                // 尝试缩小范围
                if (arr2[s.charAt(left)] != 0) {
                    if (--arr1[s.charAt(left)] < arr2[s.charAt(left)]) diff++;
                }
                left++;
            }
        }

        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }

    public static void main(String[] args) {
        System.out.println(new MinWindow().minWindow("a", "aa"));
    }
}
