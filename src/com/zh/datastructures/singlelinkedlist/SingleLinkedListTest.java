package com.zh.datastructures.singlelinkedlist;

import com.zh.datastructures.singlelinkedlist.SingleLinkedList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SingleLinkedListTest {

    @Test
    @DisplayName("测试链表的插入操作")
    public void testInsert() {
        // 测试头插法
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        SingleLinkedList linkedList = singleLinkedList.getLinkedList();
        // linkedList.foreach(System.out::println);
        // for (Integer value : linkedList) {
        //     System.out.println(value);
        // }
        assertIterableEquals(List.of(1, 2, 3), linkedList);  // 需要实现Iterable接口才能用这个断言

        // 测试尾插法
        SingleLinkedList singleLinkedList2 = new SingleLinkedList();
        singleLinkedList2.addLast(1);
        singleLinkedList2.addLast(2);
        singleLinkedList2.addLast(3);
        assertIterableEquals(List.of(1, 2, 3), singleLinkedList2);

        // 测试插入操作

        // 测试尾插法
        SingleLinkedList singleLinkedList3 = new SingleLinkedList();
        SingleLinkedList linkedList3 = singleLinkedList3.getLinkedList();
        linkedList3.insert(0, 10);
        linkedList3.insert(4, 9);
        for (Integer value : linkedList3) {
            System.out.println(value);
        }
        assertIterableEquals(List.of(10, 1, 2, 3, 9), linkedList3);
        // 用于测试是否抛特定类型的异常，后面传入的参数是一个函数
        assertThrows(IllegalArgumentException.class, () -> {
            linkedList3.insert(-1, 10);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            linkedList3.insert(6, 100);
        });
    }

    @Test
    @DisplayName("测试链表的查找操作")
    public void testSearch() {
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        SingleLinkedList linkedList = singleLinkedList.getLinkedList();
        for (Integer value : linkedList) {
            System.out.println(value);
        }
        assertEquals(2, linkedList.getIndexByValue(3));
        assertEquals(-1, linkedList.getIndexByValue(10086));
        assertEquals(3, linkedList.getValueByIndex(2));
        assertThrows(IllegalArgumentException.class, () -> linkedList.getValueByIndex(3));
    }

    @Test
    @DisplayName("测试链表的删除操作")
    public void testDelete() {
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        SingleLinkedList linkedList = singleLinkedList.getLinkedList();
        // 测试删除第一个元素
        int removedValue = linkedList.removeFirst();
        for (Integer value : linkedList) {
            System.out.println(value);
        }
        assertEquals(1, removedValue);
        assertIterableEquals(List.of(2, 3), linkedList);

        // // 测试删除最后一个元素
        int removedValue2 = linkedList.removeLast();
        assertEquals(3, removedValue2);

        // 测试根据索引删除元素
        linkedList.addLast(3);
        linkedList.addLast(4);
        linkedList.addLast(5);
        for (Integer value : linkedList) {
            System.out.print(value + "  ");
        }
        linkedList.remove(3);
        assertIterableEquals(List.of(2, 3, 4), linkedList);
        assertThrows(IllegalArgumentException.class, () -> {
            linkedList.remove(3);
        });

    }

    @Test
    @DisplayName("测试链表的求长度和清空链表的操作")
    public void testDelAndClear() {
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        SingleLinkedList linkedList = singleLinkedList.getLinkedList();
        int size = linkedList.size();
        assertEquals(3, size);
        linkedList.clear();
        int newSize = linkedList.size();
        assertEquals(0, newSize);
    }

    @Test
    @DisplayName("测试链表的增强for遍历")
    public void testLoop() {
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        SingleLinkedList linkedList = singleLinkedList.getLinkedList();
        for (Integer value : linkedList) {
            System.out.println(value);
        }
    }
}
