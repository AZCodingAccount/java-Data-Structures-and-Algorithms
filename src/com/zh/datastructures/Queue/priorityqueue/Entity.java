package com.zh.datastructures.Queue.priorityqueue;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2023-12-01 16:05
 * @description: 定义队列中的元素类
 **/
public class Entity implements Priority {
    public String name;
    private int priority;

    public Entity(String name, int priority) {
        this.name = name;
        this.priority = priority;
    }

    @Override
    public int priority() {
        return this.priority;
    }

    @Override
    public String toString() {
        return "Entity{" +
                "name='" + name + '\'' +
                ", priority=" + priority +
                '}';
    }
}
