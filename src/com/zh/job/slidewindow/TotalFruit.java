package com.zh.job.slidewindow;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-08-01 18:53
 * @description: 水果成篮—lc904
 **/
public class TotalFruit {
    public int totalFruit(int[] fruits) {
        int len = fruits.length;
        HashMap<Integer, Integer> map = new HashMap<>(); // key为值，value为出现频率
        int left = 0, right = 0, res = 0;
        while (right < len && left <= right) {
            if (map.containsKey(fruits[right])) {
                map.computeIfPresent(fruits[right], (key, value) -> value + 1);
                right++;
                res = Math.max(res, right - left);
            } else {  // 决定能不能把当前字符加进来
                if (map.size() < 2) {
                    map.put(fruits[right++], 1); // 无脑加就行了
                    res = Math.max(res, right - left);
                } else {  // ==2了，要移动左边，移除走一个元素
                    while (map.size() >= 2) {
                        // 给当前值--
                        int leftKey = fruits[left];
                        map.computeIfPresent(leftKey, (key, value) -> value - 1);
                        if (map.get(leftKey) == 0) map.remove(leftKey);
                        left++;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new TotalFruit().totalFruit(new int[]{3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4}));
    }
}
