package com.zh.job.greedy;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-06-19 21:40
 * @description: 摆动序列—lc376
 **/
public class WiggleMaxLength {
    /*
            妈妈告诉我们，子序列和子串是不一样的，子序列可以跳着来，不用连续。这里就是找一个上下最多的。
        因此贪心策略是删除上坡或者下坡的元素，让g点最多即可。三种情况
        1：处理首尾元素（也解决了12的情况） preDiff从0开始，加上虚拟头结点。从1开始，默认右边有一个元素
        2：解决中间有平坡的情况           preDiff==0的情况
        3：解决连续上坡然后平坡的情况      把preDiff赋值放到坡点改变的情况。
     */

    public int wiggleMaxLength(int[] nums) {
        if (nums.length == 1) {
            return 1;
        }
        int top = 1;    // 摆动元素个数
        int preDiff = 0;    // 当前节点和上1一个节点的差值
        int currDiff = 0;   // 下一个节点和当前节点差值
        for (int i = 1; i < nums.length; i++) {
            currDiff = nums[i] - nums[i - 1];
            if ((preDiff >= 0 && currDiff < 0)  // 上g点
                    || (preDiff <= 0 && currDiff > 0)) {    // 下g点
                top++;
                preDiff = currDiff; // 解决223的情况
            }
        }
        return top;
    }

    public static void main(String[] args) {
        System.out.println(new WiggleMaxLength().wiggleMaxLength(new int[]{1, 7,4,9,2,5}));
    }
}
