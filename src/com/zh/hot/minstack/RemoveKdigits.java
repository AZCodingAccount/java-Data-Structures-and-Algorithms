package com.zh.hot.minstack;

import java.util.LinkedList;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-07-17 17:09
 * @description: 移掉K位数字—lc402
 **/
public class RemoveKdigits {
    public String removeKdigits(String num, int k) {
        if (num.length() == k) return "0";
        LinkedList<Integer> deque = new LinkedList<>();
        StringBuilder res = new StringBuilder();
        deque.offerFirst(num.charAt(0) - '0');
        for (int i = 1; i < num.length(); i++) {
            Integer peeked = deque.peekFirst();
            Integer curr = num.charAt(i) - '0';
            if (curr < peeked && k != 0) {
                // 把之前的都弹出来
                while (!deque.isEmpty() && curr < deque.peekFirst()) {
                    deque.pollFirst();
                    k--;
                    if (k == 0) break;
                }
            }
            deque.offerFirst(curr);
        }
        // 处理递增情况 比如112，单调栈此时不知道怎么删
        while (k-- > 0) {
            deque.pollFirst();
        }
        // 处理前导0
        while (deque.size() > 1 && deque.peekLast() == 0) {
            deque.pollLast();
        }
        // 正常取数据
        while (!deque.isEmpty()) {
            res.append(deque.pollLast());
        }
        return res.toString();
    }

    public static void main(String[] args) {
        // System.out.println(new RemoveKdigits().removeKdigits("1432219", 3));
        // System.out.println(new RemoveKdigits().removeKdigits("10200", 1));
        System.out.println(new RemoveKdigits().removeKdigits("112", 1));
    }
}
