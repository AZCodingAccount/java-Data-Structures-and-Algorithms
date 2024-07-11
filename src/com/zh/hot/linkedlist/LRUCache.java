package com.zh.hot.linkedlist;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-07-11 18:09
 * @description: LRU缓存—lc146
 **/
public class LRUCache {
    class Node {    // 双向链表节点
        Node prev, next;
        int key, val;

        public Node() {
        }

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    int capacity;
    int size;
    HashMap<Integer, Node> map;
    Node head, tail;    // 虚拟头尾节点

    public LRUCache(int capacity) {
        this.capacity = capacity;
        size = 0;
        map = new HashMap<>();
        head = new Node();
        tail = new Node();
        // 连接双向链表 head tail
        head.next = tail;
        tail.prev = head;
    }

    /*
        放入元素
            1：检查关键字是否存在，存在就更新哈希表和双向链表
            2：不存在首先插到双向链表后面,然后放入哈希表
                2.1：然后检查是否满了，如果满了双向链表头部元素出队
    */
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.val = value;
            updatePriority(node);
            map.put(key, node); // 更新哈希表
        } else {
            Node node = new Node(key, value);
            // 插入链表中
            addNode(node);
            map.put(key, node);
            if (++size > capacity) {
                // 链表头部元素出队
                removeNode();
            }
        }
    }

    // 移除头结点
    private void removeNode() {
        map.remove(head.next.key);
        head.next = head.next.next;
        head.next.prev = head;
        size--;
    }

    // 更新节点优先级
    private void updatePriority(Node node) {
        // 删除当前节点并把这个节点放到最后面，更新访问       head 1<——>2<——>3 tail
        node.prev.next = node.next;
        node.next.prev = node.prev;
        // 插入节点
        addNode(node);
    }

    // 插入新节点
    private void addNode(Node node) {
        tail.prev.next = node;
        node.prev = tail.prev;
        node.next = tail;
        tail.prev = node;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            updatePriority(node);
            return node.val;
        }
        return -1;
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        System.out.println(lruCache.get(1));
        lruCache.put(3, 3);
        System.out.println(lruCache.get(2));
        lruCache.put(4, 4);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(3));
        System.out.println(lruCache.get(4));
    }
}
