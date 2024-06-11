package com.zh.multithread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-06-11 16:22
 * @description: 使用Lock锁交替打印ABC
 **/
public class LockPrintABC {
    private static final Lock lock = new ReentrantLock();
    private static final Condition conditionA = lock.newCondition();
    private static final Condition conditionB = lock.newCondition();
    private static final Condition conditionC = lock.newCondition();
    private static int state = 0; // 0: print A, 1: print B, 2: print C

    public static void main(String[] args) {
        Thread threadA = new Thread(new PrintTask('A', 0, conditionA, conditionB));
        Thread threadB = new Thread(new PrintTask('B', 1, conditionB, conditionC));
        Thread threadC = new Thread(new PrintTask('C', 2, conditionC, conditionA));

        threadA.start();
        threadB.start();
        threadC.start();
    }

    static class PrintTask implements Runnable {
        private final char letter;
        private final int targetState;
        private final Condition currentCondition;
        private final Condition nextCondition;

        PrintTask(char letter, int targetState, Condition currentCondition, Condition nextCondition) {
            this.letter = letter;
            this.targetState = targetState;
            this.currentCondition = currentCondition;
            this.nextCondition = nextCondition;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) { // 打印10轮
                lock.lock();
                try {
                    while (state != targetState) {
                        currentCondition.await();   // 等待
                    }
                    System.out.println(Thread.currentThread().getName() + "  " + letter);
                    state = (state + 1) % 3;    // 更新记录的state
                    nextCondition.signal();     // 唤醒下一个条件
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } finally {
                    lock.unlock();
                }
            }
        }
    }
}
