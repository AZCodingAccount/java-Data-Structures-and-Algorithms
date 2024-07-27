package com.zh.job.str;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-07-27 16:56
 * @description: 字符串排列—lc567
 **/
public class CheckInclusion {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length()>s2.length()) return false;
        int[] freq = new int[26];
        int len = s1.length();
        for (int i = 0; i < len; i++) {
            freq[s1.charAt(i) - 'a']++;
            freq[s2.charAt(i) - 'a']--;
        }
        int diff = 0;
        for (int c : freq) {
            if (c != 0) diff++;
        }
        if (diff == 0) return true;
        // s2直接开len的窗口滑动
        for (int i = len; i < s2.length(); i++) {
            int right = s2.charAt(i) - 'a', left = s2.charAt(i - len) - 'a';
            if (left == right) continue;
            // 处理右边字符
            if (freq[right] == 0) diff++;   // 坏了，又加进来一个，差异变大了
            freq[right]--;  // 尝试加进来，如果凑平了，差异变小
            if (freq[right] == 0) diff--;

            // 处理左边字符
            if (freq[left] == 0) diff++;
            freq[left]++;
            if (freq[left] == 0) diff--;
            if (diff == 0) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new CheckInclusion().checkInclusion("ab", "eidbaooo"));
    }
}
