package com.zh.job.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-07-31 19:35
 * @description: 删除子文件夹—lc1233
 **/
public class RemoveSubfolders {
    // 暴力
    public List<String> removeSubfolders2(String[] folder) {
        Arrays.sort(folder);
        System.out.println(Arrays.toString(folder));
        List<String> res = new LinkedList<>(Arrays.asList(folder));
        for (int i = 1; i < folder.length; i++) {
            if (folder[i].startsWith(folder[i - 1])) {
                String str = folder[i].substring(folder[i - 1].length()); // 剔除前缀
                if (!str.isEmpty() && str.charAt(0) == '/') {
                    // 删除该元素
                    res.remove(folder[i]);
                    folder[i] = folder[i - 1];
                }
            }
        }
        return res;
    }

    // 字典树
    class Trie {
        boolean isEnd;
        Trie[] next;
        String str; // 当前节点存的字符串

        public Trie(String str) {
            this.str = str;
            this.isEnd = false;
            this.next = new Trie[27];
        }
    }

    Trie root;

    public RemoveSubfolders() {
        root = new Trie("");
    }

    public void insert(String s) {
        Trie curr = root;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i));
            int index;
            if (s.charAt(i) == '/') {
                index = 26;
            } else {
                index = s.charAt(i) - 'a';
            }
            if (curr.next[index] == null) {
                curr.next[index] = new Trie(sb.toString());
            }
            curr = curr.next[index];
        }
        curr.isEnd = true;
    }

    public List<String> removeSubfolders(String[] folder) {
        // 建树
        RemoveSubfolders trie = new RemoveSubfolders();
        for (String s : folder) {
            trie.insert(s);
        }
        // 接下来依次遍历26个字母里面分别的开头
        List<String> res = new ArrayList<>();
        helper(res, trie.root);
        return res;
    }

    private void helper(List<String> res, Trie root) {
        if (root.isEnd) {
            res.add(root.str);
            for (int i = 0; i < root.next.length; i++) {
                if (i != 26 && root.next[i] != null) {
                    helper(res, root.next[i]);
                }
            }
            return;
        }
        for (Trie node : root.next) {
            if (node != null) { // 说明至少有一个字符串
                helper(res, node);
            }
        }
    }


    public static void main(String[] args) {
        System.out.println(new RemoveSubfolders().removeSubfolders(new String[]{"/a/b/c", "/a/b/ca", "/a/b/d"}));
    }
}
