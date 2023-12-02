package com.zh.datastructures.dynamicarray;

import com.zh.datastructures.dynamicarray.DynamicArray;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

public class DynamicArrayTest {
    // 创建数组
    public DynamicArray dynamicArray = new DynamicArray();

    @BeforeEach
    public void setUp() {
        dynamicArray = new DynamicArray();
        dynamicArray.add(1);
        dynamicArray.add(2);
        dynamicArray.add(3);
    }
    @Test
    @DisplayName("测试动态数组的添加功能")
    public void testAdd() {
        dynamicArray.add(8, 2);
        assertIterableEquals(List.of(1,2,8,3),dynamicArray);
    }

    @Test
    @DisplayName("测试动态数组的遍历功能")
    public void testPrint() {
        System.out.println("函数式接口遍历动态数组");
        // 使用函数式接口遍历
        dynamicArray.foreach(System.out::println);
        System.out.println("迭代器对象遍历动态数组");
        // 创建迭代器对象遍历
        Iterator<Integer> iterator = dynamicArray.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        // 增强for也可以，底层就是根据迭代器
        for (int element : dynamicArray) {
            System.out.println(element);
        }
        System.out.println("stream流遍历动态数组");
        // 使用stream流方式遍历
        dynamicArray.stream().forEach(System.out::println);


    }

    @Test
    @DisplayName("测试动态数组的删除功能")
    public void testDelete() {
        int deleted = dynamicArray.delete(1);
        assertEquals(2,deleted);
    }
}

