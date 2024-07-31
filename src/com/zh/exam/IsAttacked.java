package com.zh.exam;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-07-29 13:09
 * @description: 判断是否受到攻击
 **/
public class IsAttacked {
    /**
     * 判断玩家是否被攻击
     *
     * @param angle 扇形角度（应该是弧度）
     * @param r     扇形半径
     * @param x     C玩家x坐标
     * @param y     C玩家y坐标
     * @return
     */
    public boolean isAttacked(int angle, double r, double x, double y) {
        // 以主角为原点建坐标系
        // 1：求出C玩家距离主角的长度
        double playerCR = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
        // 2：求出C玩家距y轴的sin,sin(x)随x单调递增
        double playerCSin = y / playerCR;

        // 当两个条件都满足的时候才说明C玩家在主角的攻击范围内
        return r >= playerCR && playerCSin <= Math.sin(angle / 2.0);    // 扇形被y轴一分为2
    }
}
