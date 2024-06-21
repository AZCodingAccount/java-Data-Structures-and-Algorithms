package com.zh.job.lookback;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-06-21 17:14
 * @description: 分割回文串—lc131
 **/
public class Partition {
    /*
            这道题最重要的一点是理解回溯是怎么分割的，代码是怎么体现分割的，结束条件是什么。
        还是经典的startIndex，体现分割子串就是改变startIndex的值进而改变子串长度，结束条件是分割那一刀切到了最后（顺序切的）
        递归逻辑处理每个小子串是否回文可以尽量剪掉一些值，也可以收集结果时判断
     */
    List<List<String>> res = new ArrayList<>();

    LinkedList<String> deque = new LinkedList<>();  // 不要用栈，栈 push是头插法

    public List<List<String>> partition(String s) {
        dfs(s, 0);
        return res;
    }

    /**
     * 遍历函数
     *
     * @param s     原始字符串
     * @param start 起始索引 0——s.length-1
     */
    private void dfs(String s, int start) {
        if (start >= s.length()) {
            res.add(new ArrayList<>(deque));
        }

        // 从0开始，因此是start索引元素后面来一刀
        for (int i = start; i < s.length(); i++) {
            String str = s.substring(start, i + 1); // 当前截取的子字符串
            if (isPalindrome(str)) {  // 有一个不是回文这轮就可以提前结束了
                deque.offerLast(str);
                dfs(s, i + 1);
                deque.removeLast();
            }
        }
    }

    /**
     * 判断是否是回文串
     *
     * @param str 要判断的子串
     * @return 是否回文
     */
    private boolean isPalindrome(String str) {
        if (str.isEmpty() || str.length() == 1) {
            return true;
        }
        int left = 0;
        int right = str.length() - 1;
        char[] chs = str.toCharArray();
        while (left < right) {
            if (chs[left] != chs[right]) {
                return false;
            } else {
                left++;
                right--;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Partition().partition("efe"));
    }
}
