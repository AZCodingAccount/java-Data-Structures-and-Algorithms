package com.zh.datastructures.singlelinkedlist;

import java.util.Iterator;
import java.util.function.Consumer;

/*
 * 链表这个数据结构实现的功能如下：
 *   增加：1.头插法。2.尾插法。3.根据索引插入
 *   删除：1.删除链表第一个元素。2.删除链表最后一个元素。3.根据索引删除元素
 *   查找：1.根据索引查找值。2.根据值查找索引
 *   遍历：1.迭代器遍历（增强for）。2.lambda表达式遍历（consumer函数式接口）
 *   获取链表信息：1.清空链表。2.获取链表长度。
 * */
public class SingleLinkedList implements Iterable<Integer> {
    // 定义头结点，哨兵节点
    Node head = new Node(666, null);

    // 定义内部类，用来表示链表中的一个节点
    static class Node {
        int value;
        Node next;

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    /*
     * 链表插入节点：3种方式
     * 1.头插法。2.尾插法。3.根据索引插入
     * */
    public void addFirst(int value) {
        // 改变头结点的next，使其指向需要插入的节点，就插入成功了。该节点的next指针需要指向头结点指向的next指针
        head.next = new Node(value, head.next);
    }

    public void addLast(int value) {
        // 这个的实现思路是需要找到最后一个节点。然后改变最后一个节点的next指向即可
        // 把查找最后一个节点的部分抽取出来
        Node lastNode = findLast();
        lastNode.next = new Node(value, null);
    }

    private Node findLast() {
        // 使用head而不是head.next，目的在于配合下面的while条件
        Node p = head;
        while (p.next != null) {
            p = p.next;
        }
        return p;
    }

    // 根据索引插入的实现思路首先是需要找到这个索引的前一个元素，再更改一下前一个元素的指向即可。插入元素的指向也需要改一下
    public void insert(int index, int value) {
        // 把查找节点的方法抽取出来
        Node prevNode = findNode(index - 1);
        if (prevNode == null) {
            throw new IllegalArgumentException(String.format("索引%d越界", index));
        }
        prevNode.next = new Node(value, prevNode.next);// 就是上面的表述，更改两个节点的指针关系。
    }

    private Node findNode(int index) {
        /*
         * 如果索引是0，初始节点就可以是head.next。但是如果是-1，就代表头节点也包括在查询的范围内了。
         * */
        int i = -1;    // 定义索引记录当前遍历到哪个节点了
        // 这里需要使用for循环。有索引使用for循环简单点。
        for (Node p = head; p != null; p = p.next, i++) {
            if (index == i) { // 找到节点，直接返回
                return p;
            }
        }
        return null; // 找不到节点，返回null
    }

    /*
     * 进行链表的遍历。注意，这里不写遍历那个add方法都检验不了
     * 只实现两种遍历方式。1.函数式接口实现遍历。2.Iterator迭代器遍历
     * */
    // 函数式接口遍历
    public void foreach(Consumer<Integer> consumer) {
        // 把每个节点的值提供给consumer
        for (Node p = head.next; p != null; p = p.next) {
            consumer.accept(p.value);
        }
    }

    // 迭代器遍历
    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            /*
             * 实在想不通就想一下不满足hasNext的最后一个条件是什么while(hasNext){next()};
             * */
            Node p = head.next;
            // 这里的逻辑是初始化头结点

            @Override
            public boolean hasNext() {
                return p != null;// 判断下一个节点是否为空。(逻辑就是还是判断下一个节点是不是为空)
                // 如果是p.next，就会错过最后一个节点
            }

            @Override
            public Integer next() {
                // 改变指针并返回当前元素的值。这时就需要自己手动跳过头结点的值，因为在初始化节点的时候没有跳过
                int value = p.value;
                p = p.next;
                return value;
            }
        };
    }

    /*
     * 提供get方法，1.根据索引来获取链表的指定节点的值。2.根据传入的值返回当前元素的索引
     * */
    public int getValueByIndex(int index) {
        // 调用前面封装好的findNode方法返回节点，再把值返回出去
        Node node = findNode(index);
        if (node == null) {
            throw new IllegalArgumentException(String.format("索引%d越界", index));
        }
        return node.value;
    }

    public int getIndexByValue(int value) {
        // 直接遍历这个链表即可
        int i = 0;    // i=0从头结点的下一个节点遍历，i=1从头结点遍历，显然这里直接i=0；
        for (Node p = head.next; p != null; p = p.next, i++) {
            if (p.value == value) {
                return i;
            }
        }
        return -1;
    }

    /*
     * 提供移除的方法，1.根据索引移除。2.移除第一个元素。3.移除最后一个元素
     * */
    public int remove(int index) {
        // 调用之前实现的findNode方法，发现要删除的前一个元素，改变它的next指针指向即可
        Node prevNode = findNode(index - 1);
        // 处理异常，如果没有找到前一个节点，就报索引异常。
        // 还有一种情况是prevNode就是最后一个节点，这个时候需要判断一下它的next节点是不是异常
        if (prevNode == null || prevNode.next == null) {
            throw illegalIndexException(index);
        }
        Node currentNode = prevNode.next;
        int removedValue = currentNode.value;
        prevNode.next = currentNode.next;
        return removedValue;
    }

    public int removeFirst() {
        // 删除第一个元素使用下面方法使时间复杂度控制在常数级
        Node firstNode = head.next;
        // 判断链表是不是为空，为空抛异常
        if (firstNode == null) {
            throw illegalIndexException(0);
        }
        // 链表不为空就让头节点指向第一个节点的下一个节点
        int removedValue = firstNode.value;
        head.next = firstNode.next;
        return removedValue;
    }

    public int removeLast() {
        // 这里是单向链表，无法直接找到最后一个节点，因此只能采用遍历
        Node prevLastNode = findNode(size() - 2);
        if (prevLastNode == null) {
            throw illegalIndexException(0);
        }
        int removedValue = prevLastNode.next.value;
        prevLastNode.next = null;
        return removedValue;
    }

    private static IllegalArgumentException illegalIndexException(int index) {
        return new IllegalArgumentException(String.format("索引【%d】越界", index));
    }

    /*
     * 提供清空链表的方法clear
     * */
    public void clear() {
        // 直接把头结点的next指针置为空即可，Java里面有垃圾回收，其他的虚拟机会帮我们回收了
        head.next = null;
    }

    /*
     * 提供计算链表中元素的长度
     * */
    public int size() {
        // 采用while循环，逻辑跟findLast方法一样
        int size = 0;
        Node p = head;
        while (p.next != null) {
            p = p.next;
            size++;
        }
        return size;
    }


    // 提供一个测试的方法
    public SingleLinkedList getLinkedList() {
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.addFirst(3);
        singleLinkedList.addFirst(2);
        singleLinkedList.addFirst(1);
        return singleLinkedList;
    }


}
