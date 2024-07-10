package com.zh.job.lookback;

import java.util.*;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-07-10 18:04
 * @description: 课程表—lc207
 **/
public class CanFinish {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Set<Integer>> graph = new ArrayList<>();
        // 新建图的顶点
        for (int i = 0; i < numCourses; i++) {
            graph.add(new HashSet<>());
        }
        // 将顶点连接起来
        for (int i = 0; i < prerequisites.length; i++) {
            graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        // 此时图的状态是这样的  [1,2] [1,3] 1:{2,3} 代表课程2，3是课程1的先修课程
        return TS(graph);
    }

    /*
        拓扑排序—BFS，这里我的实现是把每个set的长度作为i对应的度数了
     */
    private boolean TS(List<Set<Integer>> graph) {
        LinkedList<Integer> queue = new LinkedList<>();
        // 对于没有先修课程的节点，首先先记录进来
        for (int i = 0; i < graph.size(); i++) {
            if (graph.get(i).isEmpty()) {
                queue.offer(i);
            }
        }

        // 不断更新入度
        while (!queue.isEmpty()) {
            Integer popped = queue.poll();   // 可用于更新的某个课程
            for (int i = 0; i < graph.size(); i++) {
                Set<Integer> node = graph.get(i);
                if (!node.isEmpty()) {
                    node.remove(popped);    // 入度-1，移除这个前导课程的条件
                    // 先进先出，因此可以在这里添加
                    if (node.isEmpty()) queue.offer(i);
                }
            }
        }

        // 最后判断是不是有环，判断最后所有入度（前导课程）是不是都为0即可
        for (Set<Integer> set : graph) {
            if (!set.isEmpty()) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new CanFinish().canFinish(2, new int[][]{{1, 0}, {0, 1}}));
    }
}
