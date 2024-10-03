package com.zh.codetop;

import java.util.HashMap;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-09-11 00:48
 * @description:
 **/
class LRUCache {

    class DListNode {
        DListNode prev;
        DListNode next;
        int key, value;

        public DListNode() {
        }

        public DListNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    HashMap<Integer, DListNode> map = new HashMap<>();

    int size = 0;
    int capacity;
    DListNode head, tail;

    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        head = new DListNode();
        tail = new DListNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        DListNode node = map.get(key);
        int res = -1;
        if (node != null) {
            res = node.value;
            // 删除链表节点 & 头插法
            updatePriority(node);
        }
        return res;
    }

    public void put(int key, int value) {
        DListNode node = map.get(key);
        if (node != null) {
            node.value = value;
            // 删除链表节点 & 头插法
            updatePriority(node);
        } else {
            DListNode newNode = new DListNode(key, value);
            map.put(key, newNode);
            // 头插法
            addHead(newNode);
            size++;
            // 1 1
            if (size > capacity) {  // 删除一个节点
                // 删除尾部节点
                DListNode removedNode = tail.prev;
                removeNode(removedNode);
                map.remove(removedNode.key);
                size--;
            }
        }
    }

    // 更新优先级
    private void updatePriority(DListNode node) {
        removeNode(node);

        addHead(node);
    }

    // 移除节点
    private void removeNode(DListNode removedNode) {
        removedNode.prev.next = removedNode.next;
        removedNode.next.prev = removedNode.prev;
    }

    // 头插法插入
    private void addHead(DListNode newNode) {
        DListNode temp = head.next;
        head.next = newNode;
        newNode.prev = head;
        newNode.next = temp;
        temp.prev = newNode;
    }
}