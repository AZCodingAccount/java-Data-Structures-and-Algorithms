package com.zh.algorithm.binarysearch;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TestBinarySearch {

    @Test
    @DisplayName("测试")
    public void Test1() {
        // 定义要查找的数组
        int[] arr = {2, 4, 6, 8, 10};
        // 调用静态方法查找元素
        int index = BinarySearch.binarySearchBase(arr, 10);
        System.out.println(index);
    }

    @Test
    @DisplayName("返回最左边的静态方法的测试")
    public void Test2() {
        // 定义要查找的数组
        int[] arr = {2, 4, 6, 6, 6, 8, 8, 9};
        // 调用静态方法查找元素
        int index1 = BinarySearch.leftMostBinarySearch(arr, 6);
        int index2 = BinarySearch.leftMostBinarySearch(arr, 8);
        System.out.println(index1+"----"+index2);
    }

    @Test
    @DisplayName("返回最右边的静态方法的测试")
    public void Test3() {
        // 定义要查找的数组
        int[] arr = {2, 4, 6, 6, 6, 8, 8, 9};
        // 调用静态方法查找元素
        int index1 = BinarySearch.rightMostBinarySearch(arr, 6);
        int index2 = BinarySearch.rightMostBinarySearch(arr, 8);
        System.out.println(index1+"----"+index2);
    }
    @Test
    @DisplayName("返回考虑重复元素的最左边插入点的静态方法的测试")
    public void Test4() {
        // 定义要查找的数组
        int[] arr = {2, 4, 6, 6, 6, 8, 8, 9};
        // 调用静态方法查找元素
        int index1 = BinarySearch.returnInsertIndexBinarySearch1(arr, 5);
        int index2 = BinarySearch.returnInsertIndexBinarySearch1(arr, 6);
        System.out.println(index1+"----"+index2);
    }
    @Test
    @DisplayName("返回不考虑重复元素的静态方法的测试")
    //意味着随机返回，重复元素的话
    public void Test5() {
        // 定义要查找的数组
        int[] arr = {2, 4, 6, 6, 6, 8, 8, 9};
        // 调用静态方法查找元素
        int index1 = BinarySearch.returnInsertIndexBinarySearch2(arr, 5);
        int index2 = BinarySearch.returnInsertIndexBinarySearch2(arr, 6);
        System.out.println(index1+"----"+index2);
    }

}
