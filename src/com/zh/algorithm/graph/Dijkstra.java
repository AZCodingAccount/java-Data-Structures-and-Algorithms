package com.zh.algorithm.graph;


import com.zh.datastructures.graph.Graph;

import java.util.Comparator;
import java.util.Objects;
import java.util.PriorityQueue;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-03-08 20:25
 * @description: 迪杰斯特拉单源点最短路径算法
 **/
public class Dijkstra {
    /*
        迪杰斯特拉算法的步骤（求单源点最短路径，没办法处理路径权值出现负数的情况（因为其每次取的是dist最小的，如果权值为负，取的不保证dist最小了）
        但是可以处理出现环的情况）
            1：初始化所有节点的dist为∞、源点为0、将源点入队
            2：取出距离最小的顶点
            3：遍历该顶点的所有邻接顶点并将未访问过的节点入队，如果dist[v]>dist[u]+weight(u,v)，更新v节点的dist并将更新后的距离和顶点加入优先队列
            4：重复2、3，直到优先队列为空
     */
    public static void dijkstra(Graph graph) {
        PriorityQueue<Graph.Vertex> queue = new PriorityQueue<>(Comparator.comparingInt(v -> v.dist));    // 存储待选择的节点
        // 1：初始化所有节点的dist为∞、源点为0
        for (Graph.Vertex value : graph.vertices.values()) {
            if (Objects.equals(value.name, "1")) {
                value.dist = 0;
            } else {
                value.dist = Integer.MAX_VALUE;
            }
        }

        // 源点入队
        queue.offer(graph.getHeadV("1"));

        // 4：重复2、3，直到优先队列为空
        while (!queue.isEmpty()) {
            // 2:取出距离最小的顶点
            Graph.Vertex vertex = queue.poll();
            vertex.isVisited = true;// 标记为已访问
            // 3：遍历邻接顶点
            for (Graph.Edge edge : vertex.edges) {
                if (edge.linked.dist > vertex.dist + edge.height) {
                    // 更新当前节点的dist
                    edge.linked.dist = vertex.dist + edge.height;
                }
                if (!edge.linked.isVisited) {
                    // 加入优先队列
                    queue.offer(edge.linked);
                }
            }
        }

        printGraph(graph);  // 打印这个图
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
        dijkstra(graph);
    }
}
