package com.zh.job;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-03-20 16:31
 * @description: 能够环路——leetcode134
 **/
public class CanCompleteCircuit {
    /*
            这个结论是如果你从A经过B到达不了C，那么从B开始也到达不了C，因此可以利用这个特性
    我的第一个解法虽然优化了，虽然内层循环仍然可能重复访问元素，但总体而言时间复杂度到不了O（n）
     */
    public int canCompleteCircuitFalse(int[] gas, int[] cost) {
        int n = gas.length;
        int i = 0;
        // 需要判断本轮循环是否轮询过一轮
        while (i < n) {
            // 对每个出发点都进行检查
            int p = i;  // 移动的指针
            boolean isCircuit = true;
            int myGas = 0;  // 累计的汽油量
            int count = 0;  // 记录跳过的个数
            do {
                count++;
                // 此路不通
                if (myGas + gas[p] < cost[p]) {
                    isCircuit = false;
                    i = i + count; // 从当前的下一个开始
                    break;
                } else {  // 更新剩下的油
                    myGas += (gas[p] - cost[p]);
                }
                p = (p + 1) % n;

            } while (p != i);
            if (isCircuit) {  // 找到解
                return i;
            }
        }
        return -1;
    }


    /*
            这个版本的解法是，记录总的油量，和当前处理的起点的油量
            1：总油量大于0说明，无论从哪个点开始，至少存在一个点使得可以形成环
            2：当前处理的油量小于0说明当前处理的点和他遍历过的点都不可能是 可能的解，start从i+1开始
            3：处理结束以后，由于题目说存在唯一解，如果有解，就算当前start没有被验证，仍然也可以被认为是解
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalOil = 0;
        int currOil = 0;
        int start = 0;
        for (int i = 0; i < gas.length; i++) {
            totalOil += (gas[i] - cost[i]);
            currOil += (gas[i] - cost[i]);
            if (currOil < 0) {  // 当前的这个start不是解
                currOil = 0;
                start = i + 1;
            }
        }
        return totalOil >= 0 ? start : -1;
    }

    public static void main(String[] args) {
        int[] gas = new int[]{2, 3, 4};
        int[] cost = new int[]{3, 4, 3};
        System.out.println(new CanCompleteCircuit().canCompleteCircuitFalse(gas, cost));
        System.out.println(new CanCompleteCircuit().canCompleteCircuit(gas, cost));
    }
}
