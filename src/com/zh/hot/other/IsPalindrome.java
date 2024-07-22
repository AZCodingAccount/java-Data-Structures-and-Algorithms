package com.zh.hot.other;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-07-22 21:17
 * @description: 判断回文数—lc9
 **/
public class IsPalindrome {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        int num = 0;
        while (x > num) {   // 当x<=num时，说明已经反转了一半 1221 12321
            num = x % 10 + num * 10;
            if (num == 0) return false;    // 处理10的情况，说明有后置0
            x /= 10;
        }
        // 这样的情况123 12或12 12
        return (x == num) || (num / 10 == x);
    }
}
