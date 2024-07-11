package com.zh.hot.tree;

class Trie {
    static class TrieNode {
        boolean isEnd;  // 当前是否结束
        TrieNode[] next;    // 当前节点对应的下一些节点

        public TrieNode() {
            isEnd = false;
            next = new TrieNode[26];  // 26个英文字母
        }
    }

    TrieNode root;  // 树的头节点，可以粗略认为它是一个点而不是一个TrieNode结构，next才开始存

    public Trie() {
        root = new TrieNode();
    }

    // 插入的流程，遍历每个字符，然后一次填入每个节点，插入abc
    public void insert(String word) {
        TrieNode curr = root;
        for (int i = 0, ch; i < word.length(); i++) {
            ch = word.charAt(i) - 'a';
            if (curr.next[ch] == null) {
                curr.next[ch] = new TrieNode();
            }
            curr = curr.next[ch];
        }
        // 最后把当前节点标记为结束，方便search方法
        curr.isEnd = true;
    }

    // 寻找这个字符串在前缀树中是否存在，遍历完毕以后看看isEnd是不是为true或者遍历过程中树中不存在这个字符
    public boolean search(String word) {
        TrieNode curr = root;
        for (int i = 0, ch; i < word.length(); i++) {
            ch = word.charAt(i) - 'a';
            if (curr.next[ch] == null) {
                return false;
            }
            curr = curr.next[ch];
        }
        // 最后把当前节点标记为结束，方便search方法
        return curr.isEnd;
    }

    // 寻找是不是有这个前缀
    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for (int i = 0, ch; i < prefix.length(); i++) {
            ch = prefix.charAt(i) - 'a';
            if (curr.next[ch] == null) {
                return false;
            }
            curr = curr.next[ch];
        }
        // 最后把当前节点标记为结束，方便search方法
        return true;
    }
}