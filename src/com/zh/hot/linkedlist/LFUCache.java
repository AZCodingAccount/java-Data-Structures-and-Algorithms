package com.zh.hot.linkedlist;

import java.util.HashMap;

class LFUCache {
    class Node {
        Node prev, next;
        int key, val, freq = 1;   // 访问频率

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    HashMap<Integer, Node> nodeMap = new HashMap<>();    // key存的是原始key，键存的是链表节点
    HashMap<Integer, Node> freqMap = new HashMap<>();  // key存的是频率，value存的是这个频率的链表
    int capacity = 0;
    int minFreq = Integer.MAX_VALUE;

    public LFUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        // 1: 获取目标值
        Node node = nodeMap.get(key);
        if (node == null) return -1;
        // 2: 更新访问频率
        node.freq++;
        updateFreqMap(node);
        return node.val;
    }


    public void put(int key, int value) {
        // 1：看一下是不是修改
        Node oldNode = nodeMap.get(key);
        if (oldNode != null) {
            oldNode.freq++;
            oldNode.val = value;
            updateFreqMap(oldNode);// 更新节点在freqMap的位置
            nodeMap.put(key, oldNode);
            return;
        }
        // 2：创建链表节点并添加到两个map中
        Node node = new Node(key, value);
        checkCapacity();    // 2.1: 检查是否超出容量，触发淘汰策略，先淘汰再添加
        addNode(node, 1);  // 2.2: 往freqMap中添加节点
        nodeMap.put(key, node);
        minFreq = 1;
    }

    // 检查容量是否越界
    private void checkCapacity() {
        if (nodeMap.size() == capacity) {    // 淘汰最小频率的第一个元素
            // 淘汰头结点
            Node dummy = freqMap.get(minFreq);
            nodeMap.remove(dummy.next.key);
            // 这里dummy一定有值，直接移动指针即可
            dummy.next.next.prev = dummy;
            dummy.next = dummy.next.next;
            if (dummy == dummy.next) {
                freqMap.remove(minFreq);
            }
        }
    }

    // 尾插法插入节点
    private void addNode(Node node, int freq) {
        checkInit(freq);
        Node dummy = freqMap.get(freq);
        node.prev = dummy.prev;
        node.next = dummy;
        dummy.prev.next = node;
        dummy.prev = node;
    }

    // 更新节点在freqMap的位置
    private void updateFreqMap(Node node) {
        int freq = node.freq;
        // 2.1: 从原链表中删除节点  dummy——>1<——>2<——>3——>
        node.prev.next = node.next;
        node.next.prev = node.prev;
        // 2.2: 判断新链表是否初始化，没有初始化初始化一下
        // checkInit(freq); addNode节点会检查
        // 2.3: 往新链表中加入节点，尾插法
        addNode(node, freq);
        // 2.4: 如果当前频率==最小频率，判断最小频率里面的链表是否为空
        if (freq - 1 == minFreq) {
            Node node1 = freqMap.get(minFreq);
            if (node1.next == node1) {
                minFreq = freq;
                freqMap.remove(freq - 1);
            }
        }
    }

    // 初始化freqMap单个节点
    private void checkInit(int freq) {
        Node node = freqMap.get(freq);
        if (node == null) {
            // 初始化
            Node dummy = new Node(-1, -1);
            dummy.prev = dummy;
            dummy.next = dummy;
            freqMap.put(freq, dummy);
        }
    }

    public static void main(String[] args) {
        LFUCache lfuCache = new LFUCache(2);
        lfuCache.put(1, 1);
        lfuCache.put(2, 2);
        System.out.println(lfuCache.get(1));
        lfuCache.put(3, 3);
        System.out.println(lfuCache.get(2));
    }
}