package com.zh.job.lookback;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-06-21 19:13
 * @description: 复原IP地址—lc93
 **/
public class RestoreIpAddresses {
    /*
            依旧使用startIndex来进行切分，结束条件是切分的长度==4，或者说用力过猛切出去了
        一个优化点是不要收集可行解数组，直接对字符串s进行操作。加上.点什么的，另外i+2就跳过.了，因此字符串size改变也无所谓
     */
    List<String> res = new ArrayList<>();
    LinkedList<String> deque = new LinkedList<>();

    public List<String> restoreIpAddresses(String s) {
        if (s.length() < 4) {
            return new ArrayList<>();
        }
        dfs(s, 0);
        return res;
    }


    private void dfs(String s, int start) {
        if (start >= s.length()) {
            if (deque.size() == 4) {    // 切分完成，之前已经判断了满足条件
                StringBuilder sb = new StringBuilder();
                for (String string : deque) {
                    sb.append(string);
                    sb.append(".");
                }
                sb.deleteCharAt(sb.length() - 1);
                res.add(sb.toString());
            }
            return;    // 另一种情况比如直接一下子切到了最后面
        }

        for (int i = start; i < s.length(); i++) {
            String str = s.substring(start, i + 1);
            if (isLegal(str)) {
                deque.offerLast(str);
                dfs(s, i + 1);
                deque.pollLast();
            }
        }
    }

    /*
        判断字符串是否满足题目要求
     */
    private boolean isLegal(String s) {
        if (s.length() > 1 && s.charAt(0) == '0') { // 前导0，不符合题意
            return false;
        }
        try {
            int strValue = Integer.parseInt(s);
            return strValue >= 0 && strValue <= 255;    // 转换成是否满足条件
        } catch (NumberFormatException e) { // 没办法转换
            return false;
        }
    }

    public static void main(String[] args) {
        // System.out.println(new RestoreIpAddresses().restoreIpAddresses("0000"));
        // System.out.println(new RestoreIpAddresses().restoreIpAddresses("25525511135"));
        System.out.println(new RestoreIpAddresses().restoreIpAddresses("101023"));
    }
}
