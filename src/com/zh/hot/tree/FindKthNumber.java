package com.zh.hot.tree;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-07-20 17:13
 * @description: 寻找字典序的第K小数字—lc440
 **/
public class FindKthNumber {
    public int findKthNumber(int n, int k) {
        int nodeNum = 1;   // 从1开头开始找
        k--;
        while (k > 0) {
            int nodeCnt = findCnt(nodeNum, n); // 寻找nodeNum下的所有节点数量
            if (k >= nodeCnt) {  // 跳过当前数字
                nodeNum++;
                k -= nodeCnt;
            } else {  // 缩小范围，比如2节点下有100个，k为50，那接下来就去20下面寻找，少了很多
                nodeNum *= 10;
                k--;    // 跳过当前节点2
            }
        }
        return nodeNum;
    }

    // 寻找当前节点下数字个数
    private int findCnt(int nodeNum, int n) {
        int nodeCnt = 0;
        long left = nodeNum, right = nodeNum; // 初始值
        while (left <= n) { // right也行，比如n=300，left=200，right=299,下一次就变成2000和2999了
            nodeCnt += (int) (Math.min(right, n) - left + 1); // 更新nodeCnt值
            // 接下来递归统计
            left *= 10;
            right = right * 10 + 9;
        }
        return nodeCnt;
    }

    public static void main(String[] args) {
        // System.out.println((long)6816927789 );
    }
}
