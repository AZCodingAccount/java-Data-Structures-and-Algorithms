package com.zh.problem.slidewindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-04-30 11:22
 * @description: 所有字母异位词——lc438
 **/
public class FindAnagrams {
    /*
            滑动窗口，维护一个跟p.length相同的滑动窗口，每次移动指针，都判断其中的出现次数是否相等

     */
        public List<Integer> findAnagrams(String s, String p) {
            if (s.length() < p.length()) {
                return new ArrayList<>();
            }
            int left = 0, right = p.length() - 1;
            char[] chs = s.toCharArray();
            char[] chs1 = p.toCharArray();
            int[] leftArr = new int[26];
            int[] rightArr = new int[26];
            List<Integer> res = new ArrayList<>();
            // 初始化
            for (int i = left; i <= right; i++) {
                leftArr[chs[i] - 'a']++;
            }
            for (int i = left; i <= right; i++) {
                rightArr[chs1[i] - 'a']++;
            }
            while (right < chs.length) {
                // 首先判断两个子串是否相等
                boolean equals = Arrays.equals(rightArr, leftArr);
                if (equals) {
                    res.add(left);  // 添加到结果数组中
                    // 优化，如果相等以后直接判断出去的那个元素和进来的元素是否相等
                    while (right < chs.length) {
                        if (chs[left] == chs[right + 1]) {
                            left++;
                            right++;
                            res.add(left);
                        } else {
                            break;
                        }
                    }
                }
                // 移动窗口
                left++;
                right++;
                // 更新数组
                if(right<chs.length){
                    leftArr[chs[left-1] - 'a']--;
                    leftArr[chs[right] - 'a']++;
                }

            }
            return res;
        }

    public static void main(String[] args) {
        System.out.println(new FindAnagrams().findAnagrams("cbaebabacd", "abc"));
    }
}
