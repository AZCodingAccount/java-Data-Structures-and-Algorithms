package com.zh.algorithm.dp;

import com.zh.datastructures.graph.Graph;

import java.util.Arrays;


/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-03-10 19:57
 * @description: 贝尔曼福特算法——DP思想实现
 **/
public class BellmanFord {
    /*
            贝尔曼发明了DP，在求单源点最短路径的Bellman-Ford算法也有体现。
            具体为定义一个dist数组存储源点到每个节点的最短路径，遍历边，每次遍历更新对应dist中的元素。
        因此将索引 1、2、3作为节点名不用map存储最短路了
        递推式为：dist[i]=min(dist[i],dist[j]+weight(i,j))
     */
    public static void bellmanFord(Graph graph) {
        int size = graph.vertices.size();
        int[] dist = new int[size + 1];    // 节点数+1，索引0无实际意义
        // 初始化dist数组
        for (int i = 1; i < dist.length; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[1] = 0;
        while (size-- > 0) {
            // 遍历、更新
            for (Graph.Vertex vertex : graph.vertices.values()) {
                for (Graph.Edge edge : vertex.edges) {
                    if (dist[Integer.parseInt(vertex.name)] != Integer.MAX_VALUE) {
                        dist[Integer.parseInt(edge.linked.name)] =
                                Integer.min(dist[Integer.parseInt(vertex.name)] + edge.height, dist[Integer.parseInt(edge.linked.name)]);
                    }
                }
            }
        }
        System.out.println(Arrays.toString(dist));
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
