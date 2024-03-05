package com.zh.datastructures.hashtable;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Hashtable;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2023-12-08 22:09
 * @description: 测试HashTable类
 **/
public class HashTableTest {

    @Test
    @DisplayName("测试插入更新数据")
    public void testPut() {
        HashTable hashTable = new HashTable();
        hashTable.put("张三", "18");
        hashTable.put("李四", "19");
        hashTable.put("王五", "20");
        hashTable.put("张三", "22");

        // 测试能否插入成功、测试键重复的覆盖功能
        System.out.println(hashTable);

    }

    @Test
    @DisplayName("测试获取删除和获取长度")
    public void testGetAndRemoveAndSize() {
        HashTable hashTable = new HashTable();
        hashTable.put("李四", "19");
        hashTable.put("王五", "20");
        hashTable.put("张三", "22");

        // 测试获取数据和删除数据
        Assertions.assertEquals("20", hashTable.get("王五")); // 获取数据

        // 移除头结点
        hashTable.remove("张三");
        System.out.println(hashTable);
        hashTable.put("张三", "22");
        // 移除普通节点
        hashTable.remove("王五");
        System.out.println(hashTable);

        // 测试size方法
        Assertions.assertEquals(2, hashTable.size());
    }

}
