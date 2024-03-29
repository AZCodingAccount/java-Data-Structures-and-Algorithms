package com.zh.job.hashtable;

import java.util.HashSet;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-03-29 21:19
 * @description: 快乐数——leetcode202
 **/
public class IsHappy {

    /*
                判断快乐数的算法。
            1：使用哈希Set存储，当发现记录的数存在时说明进入了环
            2：快慢指针，弗洛伊德龟兔赛跑，判断链表中是否存在环
     */
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        int sum = 0;
        while (true) {
            while (n >= 1) {
                // 813  813%10=3
                int d = n % 10;
                sum += d * d;
                n /= 10;
            }
            if (sum == 1) {
                return true;
            }
            if (!set.add(sum)) {
                return false;   // 出现重复的了
            }
            n = sum;
            sum = 0;
        }
    }

    public static void main(String[] args) {
        System.out.println(new IsHappy().isHappy(19));
    }
}
