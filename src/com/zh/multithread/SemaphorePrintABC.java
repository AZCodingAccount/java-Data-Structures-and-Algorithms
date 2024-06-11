package com.zh.multithread;

import java.util.concurrent.Semaphore;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-06-11 16:30
 * @description: 使用semaphore打印abc—信号量创建的多
 **/
public class SemaphorePrintABC {
    private static final Semaphore semaphoreA = new Semaphore(1);
    private static final Semaphore semaphoreB = new Semaphore(0);   // 初始化为0代表一开始没有共享资源
    private static final Semaphore semaphoreC = new Semaphore(0);   // 初始化为0代表一开始没有共享资源

    public static void main(String[] args) {
        Thread threadA = new Thread(new PrintTask('A', semaphoreA, semaphoreB));
        Thread threadB = new Thread(new PrintTask('B', semaphoreB, semaphoreC));
        Thread threadC = new Thread(new PrintTask('C', semaphoreC, semaphoreA));

        threadA.start();
        threadB.start();
        threadC.start();
    }

    static class PrintTask implements Runnable {
        private final char letter;
        private final Semaphore currentSemaphore;
        private final Semaphore nextSemaphore;

        PrintTask(char letter, Semaphore currentSemaphore, Semaphore nextSemaphore) {
            this.letter = letter;
            this.currentSemaphore = currentSemaphore;
            this.nextSemaphore = nextSemaphore;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) { // 打印10轮
                try {
                    currentSemaphore.acquire();
                    System.out.println(Thread.currentThread().getName() + "  " + letter);
                    nextSemaphore.release();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }
}
