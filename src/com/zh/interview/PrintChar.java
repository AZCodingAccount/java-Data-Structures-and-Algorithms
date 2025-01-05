package com.zh.interview;

import java.util.*;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-11-11 13:45
 * @description:
 **/
public class PrintChar {
    class Container {
        Character label;
        Integer val;

        public Container(Character label, Integer val) {
            this.label = label;
            this.val = val;
        }
    }

    ArrayList<Container> list = new ArrayList<>();

    void read() {
        list.add(new Container('a', 3));
        list.add(new Container('b', 2));
        list.add(new Container('c', 5));
    }

    void print() {
        PriorityQueue<Container> priorityQueue = new PriorityQueue<>((a, b) -> b.val - a.val);
        priorityQueue.addAll(list);
        Integer max = priorityQueue.peek().val;
        for (int i = 0; i < max; i++) {
            System.out.print('|');
            for (Container container : list) {
                if (container.val >= (max - i)) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.print('_');
        }
        System.out.println();
        for (Container container : list) {
            System.out.print(container.label + "");
        }
    }

    public static void main(String[] args) {
        PrintChar printChar = new PrintChar();
        printChar.read();
        printChar.print();
    }
}
