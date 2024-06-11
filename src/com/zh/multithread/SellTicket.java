package com.zh.multithread;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-06-11 16:50
 * @description: 卖票
 **/
public class SellTicket {
    public static void main(String[] args) {
        TicketSeller seller = new TicketSeller(100); // 假设一共有50张票

        Thread window1 = new Thread(new TicketWindow(seller), "窗口1");
        Thread window2 = new Thread(new TicketWindow(seller), "窗口2");
        Thread window3 = new Thread(new TicketWindow(seller), "窗口3");

        window1.start();
        window2.start();
        window3.start();
    }
}

class TicketSeller {
    private int tickets;

    public TicketSeller(int tickets) {
        this.tickets = tickets;
    }

    public synchronized boolean sellTicket() {
        if (tickets > 0) {
            tickets--;
            System.out.println(Thread.currentThread().getName() + " 卖出了1张票，剩余票数：" + tickets);
            return true;
        } else {
            System.out.println(Thread.currentThread().getName() + " 票已售罄");
            return false;
        }
    }
}

class TicketWindow implements Runnable {
    private final TicketSeller seller;

    public TicketWindow(TicketSeller seller) {
        this.seller = seller;
    }

    @Override
    public void run() {
        while (true) {
            boolean success = seller.sellTicket();
            if (!success) {
                break;
            }
            try {
                Thread.sleep(100); // 模拟售票时间
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
