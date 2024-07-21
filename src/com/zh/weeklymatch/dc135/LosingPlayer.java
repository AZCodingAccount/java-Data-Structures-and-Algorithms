package com.zh.weeklymatch.dc135;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-07-20 22:57
 * @description: 求出硬币游戏的赢家—第一题
 **/
public class LosingPlayer {
    public String losingPlayer(int x, int y) {
        int round = Math.min(x, y / 4); // 轮数
        if (round % 2 == 0) return "Bob";
        else return "Alice";
    }
}
