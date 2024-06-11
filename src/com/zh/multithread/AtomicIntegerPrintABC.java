package com.zh.multithread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-06-11 16:31
 * @description: 原子类打印ABC—需要自旋
 **/
public class AtomicIntegerPrintABC {
    private static final AtomicInteger state = new AtomicInteger(0);

    public static void main(String[] args) {
        Thread threadA = new Thread(new PrintTask('A', 0));
        Thread threadB = new Thread(new PrintTask('B', 1));
        Thread threadC = new Thread(new PrintTask('C', 2));

        threadA.start();
        threadB.start();
        threadC.start();
    }

    static class PrintTask implements Runnable {
        private final char letter;
        private final int targetState;

        PrintTask(char letter, int targetState) {
            this.letter = letter;
            this.targetState = targetState;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) { // 打印10轮
                while (true) {
                    if (state.get() == targetState) {
                        System.out.println(Thread.currentThread().getName() + "  " + letter);
                        state.set((state.get() + 1) % 3);
                        break;
                    }
                }
            }
        }
    }
}
