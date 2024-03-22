package com.zh.datastructures.graph;

import com.zh.datastructures.graph.Graph.Vertex;

import java.util.LinkedList;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-03-07 16:35
 * @description: 图的遍历
 **/
public class Traversal {

    /*
        DFS 递归|迭代
                迭代使用栈存储节点
     */
    public void DFS(Vertex vertex) {
        if (!vertex.isVisited) {    // 进来先判断是不是被访问过了，如果没有被访问（为了第一次访问）
            System.out.println(vertex.name);   // 访问这个顶点
            vertex.isVisited = true;          // 标记这个顶点为已访问
            for (Graph.Edge edge : vertex.edges) {
                if (!edge.linked.isVisited) {
                    DFS(edge.linked);   // 递归遍历子节点
                }
            }
        }
    }

    /*
        迭代使用队列存储节点
     */
    public void BFS(Vertex vertex) {
        // 初始化队列
        LinkedList<Vertex> queue = new LinkedList<>();
        queue.offer(vertex);    // 存储当前节点进入队列
        while (!queue.isEmpty()) {
            Vertex v = queue.poll();
            System.out.println(v.name); // 访问节点
            for (Graph.Edge edge : v.edges) {
                if (!edge.linked.isVisited) {
                    edge.linked.isVisited = true;
                    queue.offer(edge.linked);   // 添加新的节点
                }
            }
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

        // 遍历：DFS: 1——>6——>5——>2——>4——>3
        // new Traversal().DFS(graph.getHeadV("1"));   // 传入图的起始节点


        // BFS: 1 6 2 3 5 4
        new Traversal().BFS(graph.getHeadV("1"));   // 传入图的起始节点
    }
}
