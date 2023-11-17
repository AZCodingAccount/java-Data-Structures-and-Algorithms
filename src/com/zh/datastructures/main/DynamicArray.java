package com.zh.datastructures.main;


import java.util.Arrays;
import java.util.Iterator;
import java.util.function.Consumer;
import java.util.stream.IntStream;

/**
 * 这个动态数组类主要依托Java里面的集合思想，可以实现对数组进行扩容，增删查的操作。具体功能如下
 * 添加元素：1.根据索引插入元素，向数组尾部插入元素
 * 查询元素：根据传进来的索引查询元素
 * 删除元素：1.根据索引删除元素
 * 遍历元素：1.采用函数式接口的方式遍历。2.根据Java里面的迭代器遍历。3.根据stream流的方式遍历
 * 查询数组长度：采用size方法。
 */
public class DynamicArray implements Iterable<Integer> {
    /*
     * size是当前容量，capacity是最大容量
     * */
    private int capacity = 8;
    private int size = 0;
    private int[] arr = new int[capacity];

    public int size() {
        return size;
    }

    // 实现数组的插入元素
    public void add(int value, int index) {
        try {
            if (index > size) {
                throw new Exception("数组越界！！！");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        // 首先看数组是否需要扩容，需要扩容就扩容1.5倍
        if (size >= capacity) {
            capacity += capacity >> 1;
            int[] newArr = new int[capacity];
            // 把数据拷贝到新数组中去
            System.arraycopy(arr, 0, newArr, 0, size);
            arr = newArr;
        }
        // 再看插入的元素是不是在数组最后面，如果是最后面，直接添加，没必要copy数组了
        // 都需要进行复制和size++操作，因此抽取出来
        if (index < size) {
            System.arraycopy(arr, index, arr, index + 1, size - index);
        }
        arr[index] = value;
        size++;
    }

    // 向尾部插入数据
    public void add(int value) {
        add(value, size);
    }

    // 查询元素
    public int get(int index) {
        return arr[index];
    }

    // 遍历元素，采用函数式接口
    public void foreach(Consumer<Integer> consumer) {
        for (int i = 0; i < size; i++) {
            consumer.accept(arr[i]);
        }
    }

    // 迭代器遍历
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            int i = 0;

            @Override
            public boolean hasNext() {
                return i < size;
            }

            @Override
            public Integer next() {
                return arr[i++];
            }
        };
    }

    // 采用stream流的方式遍历
    public IntStream stream() {
        return IntStream.of(Arrays.copyOfRange(arr, 0, size));
    }

    // 删除元素，传入指定索引，删除并返回被删除的元素
    public int delete(int index) {
        // 把索引往后的元素往前移一位就可以了
        int removed = arr[index];
        System.arraycopy(arr, index + 1, arr, index, size - index - 1);
        size--;
        return removed;
    }


    @Override
    public String toString() {
        return "DynamicArray{" +
                "capacity=" + capacity +
                ", size=" + size +
                ", arr=" + Arrays.toString(arr) +
                '}';
    }
}
