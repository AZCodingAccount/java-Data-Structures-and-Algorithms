package com.zh.weeklymatch.c407;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-07-21 10:47
 * @description: 字符串元音游戏—407周赛第二题
 **/
public class DoesAliceWin {
    public boolean doesAliceWin(String s) {
        // 统计元音的个数
        int cnt = 0;
        for (char c : s.toCharArray()) {
            if (isVowel(c)) {
                cnt++;
            }
        }

        return cnt != 0;
    }
    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
