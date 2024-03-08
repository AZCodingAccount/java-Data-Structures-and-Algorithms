package com.zh.algorithm.graph;

import com.zh.datastructures.graph.Graph;

import java.util.Objects;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-03-08 21:14
 * @description: Bellman-Ford算法求单源点最短路径
 **/
public class BellmanFord {
    /*
            这个算法与迪杰斯特拉不同的是这个算法可以用来求解权重为负数的边（但不能用来处理总数为负数的环），算法通过轮数的改变对最小值进行收敛
        时间复杂度是O(VE)>Dijkstra的O(V+E)。具体步骤是：
            1：初始化所有节点的dist为∞、源点为0
            2：遍历图的每一条边，如果满足dist[v]>dist[u]+weight(u,v)，更新节点v的dist值
            3：重复步骤2 共节点个数-1轮
     */
    private static void bellmanFord(Graph graph) {
        // 1：初始化所有节点的dist为∞、源点为0
        for (Graph.Vertex value : graph.vertices.values()) {
            if (Objects.equals(value.name, "1")) {
                value.dist = 0;
            } else {
                value.dist = Integer.MAX_VALUE;
            }
        }
        int round = graph.vertices.size() - 1;
        while (round-- > 0) {
            for (Graph.Vertex vertex : graph.vertices.values()) {
                // 2：遍历图的每一条边
                for (Graph.Edge edge : vertex.edges) {
                    // 如果满足dist[v]>dist[u]+weight(u,v)，更新节点v的dist值
                    // 如果vertex.dist == Integer.MAX_VALUE，那么后面的节点的dist一定不小于整数的最大值，就没有判断的必要了
                    if (vertex.dist != Integer.MAX_VALUE && edge.linked.dist > edge.height + vertex.dist) {
                        edge.linked.dist = edge.height + vertex.dist;
                    }
                }
            }
        }
        judgeCicrle(graph); // 判断是否存在负权重的环
        printGraph(graph);
    }

    private static void judgeCicrle(Graph graph) {
        for (Graph.Vertex vertex : graph.vertices.values()) {
            // 2：遍历图的每一条边
            for (Graph.Edge edge : vertex.edges) {
                // 如果还能更新，说明一定存在环了
                if (vertex.dist != Integer.MAX_VALUE && edge.linked.dist > edge.height + vertex.dist) {
                    throw new IllegalArgumentException("存在总数为负权重的环！！！");
                }
            }
        }
    }

    public static void printGraph(Graph graph) {
        for (Graph.Vertex value : graph.vertices.values()) {
            System.out.println(value.name + "   " + value.dist);
        }
    }


    public static void main(String[] args) {
        Graph graph = new Graph();
        // 创建几个顶点
        graph.addVertex("1");
        graph.addVertex("2");
        graph.addVertex("3");
        graph.addVertex("4");
        graph.addVertex("5");
        graph.addVertex("6");

        // 创建对应的边
        graph.addEdge("1", "6", 14);
        graph.addEdge("1", "2", 7);
        graph.addEdge("1", "3", 9);
        graph.addEdge("6", "5", 9);
        graph.addEdge("2", "4", 15);
        graph.addEdge("3", "6", 2);
        graph.addEdge("3", "4", 11);
        graph.addEdge("4", "5", 6);
        // graph.addEdge("2", "1", -100);   // 创建总数为负数的环
        bellmanFord(graph);
    }

}
