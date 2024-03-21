package com.zh.algorithm.dp;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-03-10 20:19
 * @description: 完全背包问题
 **/
public class TotalKnapsack {
    /*
        完全背包问题不限制每个物品能装几个了，跟0-1背包问题递推式基本相同，修改了两个地方
        1：初始化时候注意考虑一件物品也可以多装几次了
        2: 最后装进去那个递推式变成当前物品了 dp[i-1][j-item.weight]+item.value——> dp[i][j-item.weight]+item.value
        最多10g
            weight      price
             4          1600
             8          2400
             3          30
             1          1_000_000
         首先构建一个二维表格，接下来的工作填表即可，行代表添加前几个物品，列代表总物品的总量。i行j列意思就是前i个物品在j重量情况下的最大价值
           0    1   2   3   4   5   6   7   8   9   10
         0
         1
         2
         3
         递推式为：
            if(装不下){
                直接继承上一个物品在这个重量上的最大价值    dp[i][j]=dp[i-1][j]
            }else{
                装得下看看自己是不是真的要装这件物品（比如10g水和9g石油、稀土这种，你会选择要这10g水而把装进去的9g石油给扔了吗）
                先假设装进去看看当前的收益、再跟不装这个的时候的最大收益比看哪个更大。递推式：
                    dp[i][j]=max(dp[i-1][j],dp[i][j-item.weight]+item.value)
            }
     */
    // 重量和价格
    static class Item {
        int weight;
        int price;

        public Item(int weight, int price) {
            this.weight = weight;
            this.price = price;
        }
    }

    public static void main(String[] args) {
        // 准备要放入背包的物品
        Item[] items = new Item[]{new Item(4, 1600),
                new Item(8, 2400),
                new Item(3, 30),
                new Item(1, 1_000_000)};
        int maxWeight = 10;
        int maxValue = Knapsack(items, maxWeight);
        System.out.println(maxValue);   // 10_000_000
    }

    private static int Knapsack(Item[] items, int maxWeight) {
        int[][] dp = new int[items.length][maxWeight + 1];  // 状态数组
        // 初始化只有一个物品时的数组——这里需要注意可以放置多个
        for (int i = 1; i < maxWeight + 1; i++) {
            if (i >= items[0].weight) {
                // 说明i是items[0].weight的倍数
                dp[0][i] = dp[0][i - items[0].weight] + items[0].price;
            }
        }

        // 进行dp
        for (int i = 1; i < items.length; i++) {   // 第i+1个物品
            for (int j = 1; j < maxWeight + 1; j++) {    // 第i1个重量
                if (items[i].weight <= j) {     // 可以装下
                    dp[i][j] = Integer.max(dp[i - 1][j], dp[i][j - items[i].weight] + items[i].price);
                } else {                      // 装不下
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[items.length - 1][maxWeight]; // 返回数组中的最后一个值
    }
}
