package com.zh.algorithm.recursive;

import java.util.LinkedList;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2023-11-12 22:04
 * @description: 汉诺塔代码实现
 **/
public class Hanoi {
    // 定义三个链表集合表示三根柱子
    static LinkedList<Integer> a = new LinkedList<>();
    static LinkedList<Integer> b = new LinkedList<>();
    static LinkedList<Integer> c = new LinkedList<>();

    // 定义一个变量存储移动次数
    static long count;

    static void init(int n) {
        count = 0;
        // 将a柱子进行初始化，尾插法，相当于最大的在最下面
        for (int i = 1; i <= n; i++) {
            a.addLast(i);
        }
    }

    // 打印柱子的移动，接收三个参数，分别是源，中间，目的地
    static void print() {
        count += 1;
        System.out.println("a柱：" + a + "b柱：" + b + "c柱：" + c);
        System.out.println("---------------------------");
    }

    // 真正工作的函数，接收四个参数，分别是当前圆盘数，源，中间，目的地圆盘
    /*
    主要就是三步，第一步，把n-1个上面的盘子从a->b，第二步，把最下面的盘子移动到a->c
    第三步，把b那边的n-1个盘子从b->c。
    需要注意的是，最后removeFirst，虽然是抽象出来了，但是最后还是你得先移动最上面那个盘子，不能坏了规矩。如果你removeLast，就代表你是从下面抽了。
    当然，这里的first，last取决于你初始化时赋予的含义。你还可以直接不要盘子，就是三个字符串，仅仅打印移动的步骤就可以（事实上基本是这么干的）
     */
    static void hanoi(int n, LinkedList<Integer> a, LinkedList<Integer> b, LinkedList<Integer> c) {
        // 定义递归出口
        if (n == 0) {
            return;
        }
        // 将n-1个圆盘从a移动到b
        hanoi(n - 1, a, c, b);
        // 将最后一个圆盘移动到c，这里是可以直接打印的，但是这里既然都用链表了，那就再删除添加一下吧
        c.addFirst(a.removeFirst());
        print(); // 打印一下这次移动的信息
        // 将剩下的n-1个圆盘从b移动到c
        hanoi(n - 1, b, a, c);
    }

    public static void main(String[] args) {
        init(20);
        System.out.println("初始化状态:" + "a柱：" + a + "b柱：" + b + "c柱：" + c);
        System.out.println("---------------------------");
        hanoi(20, a, b, c);
        System.out.println("移动完毕，移动总次数为：" + count); // 1048575， 20个就 100多万了，64个2^64次方得多恐怖
    }
}
