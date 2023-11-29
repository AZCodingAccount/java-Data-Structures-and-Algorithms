package com.zh.datastructures.stack;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2023-11-29 14:38
 * @description: 栈的测试
 **/
public class StackTest {
    @DisplayName("链表实现栈的测试")
    @Test
    public void testLinkedListStack(){
        LinkedListStack<Integer> stack=new LinkedListStack<>(5);
        // 测试入栈
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        assertFalse(stack.push(10));
        assertIterableEquals(List.of(5,4,3,2,1),stack);


        // 测试判满
        assertTrue(stack.isFull());

        // 测试出栈
        assertEquals(5,stack.pop());
        assertIterableEquals(List.of(4,3,2,1),stack);

        // 测试查看栈顶元素
        assertEquals(4,stack.peek());
        assertIterableEquals(List.of(4,3,2,1),stack);

        // 测试判空
        for (int i = 0; i < 4; i++) {
            stack.pop();
        }
        assertTrue(stack.isEmpty());
    }

    @DisplayName("数组实现栈的测试")
    @Test
    public void testArrayStack(){
        ArrayStack<Integer> stack=new ArrayStack<>(5);
        // 测试入栈
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        assertFalse(stack.push(10));
        assertIterableEquals(List.of(5,4,3,2,1),stack);


        // 测试判满
        assertTrue(stack.isFull());

        // 测试出栈
        assertEquals(5,stack.pop());
        assertIterableEquals(List.of(4,3,2,1),stack);

        // 测试查看栈顶元素
        assertEquals(4,stack.peek());
        assertIterableEquals(List.of(4,3,2,1),stack);

        // 测试判空
        for (int i = 0; i < 4; i++) {
            stack.pop();
        }
        assertTrue(stack.isEmpty());
    }

}
