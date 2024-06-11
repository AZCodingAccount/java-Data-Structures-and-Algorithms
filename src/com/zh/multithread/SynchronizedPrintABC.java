package com.zh.multithread;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-06-11 16:14
 * @description: 使用Synchronized交替打印abc
 **/
public class SynchronizedPrintABC {

    private static final Object lock = new Object();
    private static int state = 0; // 0: print A, 1: print B, 2: print C

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
                synchronized (lock) {
                    while (state != targetState) {  // 应对假唤醒或者state状态改变的情况
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                    System.out.println(Thread.currentThread().getName() + "  " + letter);
                    state = (state + 1) % 3;    // 更新state的值，指向下一个工作线程
                    lock.notifyAll();   // 唤醒所有线程
                }
            }
        }
    }
}
