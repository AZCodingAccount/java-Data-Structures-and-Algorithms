package com.zh.hot.lookback;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-07-26 21:31
 * @description: 单词拆分2—lc140
 **/
public class WordBreak {
    List<String> res = new ArrayList<>();

    LinkedList<String> deque = new LinkedList<>();

    public List<String> wordBreak(String s, List<String> wordDict) {
        backTrack(s, wordDict, 0);
        return res;
    }

    private void backTrack(String s, List<String> wordDict, int start) {
        if (start >= s.length()) {
            StringBuilder sb = new StringBuilder();
            for (String string : deque) {
                sb.append(string).append(" ");
            }
            sb.deleteCharAt(sb.length() - 1);
            res.add(sb.toString());
            return;
        }
        for (int i = start; i < s.length(); i++) {
            String sub = s.substring(start, i + 1);
            if (wordDict.contains(sub)) {
                deque.offerLast(sub);
                backTrack(s, wordDict, i + 1);
                deque.pollLast();
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new WordBreak().wordBreak("catsanddog", List.of("cat", "cats", "and", "sand", "dog")));
    }
}
