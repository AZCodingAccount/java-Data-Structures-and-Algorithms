package com.zh.weeklymatch.c408;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-07-28 11:16
 * @description: 408周赛第三题— 统计 1 显著的字符串的数量
 **/
public class NumberOfSubstrings {
    public int numberOfSubstrings(String s) {
        int n = s.length();
        int count = 0;
        int[] zeros = new int[n + 1]; // 前缀和数组，统计0的数量
        int[] ones = new int[n + 1]; // 前缀和数组，统计1的数量

        for (int i = 0; i < n; i++) {
            zeros[i + 1] = zeros[i] + (s.charAt(i) == '0' ? 1 : 0);
            ones[i + 1] = ones[i] + (s.charAt(i) == '1' ? 1 : 0);
        }

        for (int start = 0; start < n; start++) {
            int minEnd = findMinEnd(start, zeros, ones, n); // 你需要实现这个函数来确定最小的 end
            for (int end = minEnd; end < n; end++) {
                int zeroCount = zeros[end + 1] - zeros[start];
                int oneCount = ones[end + 1] - ones[start];
                if (oneCount >= zeroCount * zeroCount) {
                    count++;
                }
            }
        }

        return count;
    }
    private int findMinEnd(int start, int[] zeros, int[] ones, int n) {
        int minEnd = start;
        while (minEnd < n) {
            int zeroCount = zeros[minEnd + 1] - zeros[start];
            int oneCount = ones[minEnd + 1] - ones[start];
            if (oneCount >= zeroCount * zeroCount) {
                break;
            }
            minEnd++;
        }
        return minEnd;
    }


}
