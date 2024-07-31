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
        int[] inDeg = new int[numCourses];
        // 将顶点连接起来
        for (int i = 0; i < prerequisites.length; i++) {
            graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
            inDeg[prerequisites[i][0]]++;
        }
        // 此时图的状态是这样的  [1,2] [1,3] 1:{2,3} 代表课程2，3是课程1的先修课程
        // 新更新了一下（优化）  [1,2] [1,3] 2:{1}、3:{1}、1{}
        return TS(graph, inDeg);
    }

    /*
        拓扑排序—BFS，这里我的实现是把每个set的长度作为i对应的度数了
     */
    private boolean TS(List<Set<Integer>> graph, int[] inDeg) {
        LinkedList<Integer> queue = new LinkedList<>();
        // 对于没有先修课程的节点，首先先记录进来
        for (int k = 0; k < inDeg.length; k++) {
            if (inDeg[k] == 0) {
                queue.offer(k);
            }
        }

        // 不断更新入度
        while (!queue.isEmpty()) {
            Integer popped = queue.poll();   // 可用于更新的某个课程
            // 此时找到这个课程的所有第二个课程
            Set<Integer> nodes = graph.get(popped);
            for (Integer node : nodes) {
                if (--inDeg[node] == 0) queue.offer(node);
            }
        }

        // 最后判断是不是有环，判断最后所有入度（前导课程）是不是都为0即可
        for (int i : inDeg) {
            if (i != 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new CanFinish().canFinish(2, new int[][]{{1, 0}}));
    }
}
