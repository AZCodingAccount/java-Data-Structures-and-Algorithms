package com.zh.algorithm.graph;

import com.zh.datastructures.graph.Graph;

import java.util.Collection;
import java.util.LinkedList;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-03-08 17:04
 * @description: 拓扑排序
 **/
public class TopologicalSorting {

    /*
        拓扑排序的典型应用场景是学习课程，具体是三个步骤
            1：构建图
            2：为每个节点统计度
            3：遍历图的每个节点（如果入度为0，就取出当前节点，并更新与节点相邻的入度）
            4：如果有入度不为0的节点，说明出现了环
     */
    public static void TS(Graph graph) {
        Collection<Graph.Vertex> vertices = graph.vertices.values();
        // 2：为每个节点统计度
        for (Graph.Vertex value : vertices) {
            // 遍历每个节点的边
            for (Graph.Edge edge : value.edges) {
                edge.linked.inDegree++;
            }
        }

        /*for (Graph.Vertex value : vertices) {
            System.out.println(value.name + "----" + value.inDegree);
        }*/
        // 3: 遍历图的每个节点：BFS（不要用普通的BFS，只在队列遍历的时候判断度数为0，只有当度数为0时才允许他加入到队列中）
        LinkedList<Graph.Vertex> queue = new LinkedList<>();    // 存储度数为0的节点
        // 给队列初始化
        for (Graph.Vertex vertex : vertices) {
            if (vertex.inDegree == 0) {
                queue.offer(vertex);
            }
        }
        while (!queue.isEmpty()) {
            Graph.Vertex v = queue.poll();// 取出节点
            System.out.println(v.name); // 访问节点
            // 更新度数
            for (Graph.Edge edge : v.edges) {
                edge.linked.inDegree--;
                if (edge.linked.inDegree == 0) {
                    queue.offer(edge.linked);   // 入度为0，加入队列让遍历
                }
            }
            v.isVisited = true;
        }

        // 判断是否出现环
        for (Graph.Vertex vertex : vertices) {
            if (vertex.inDegree != 0) {
                throw new IllegalArgumentException("出现了环");
            }
        }
    }

    public static void main(String[] args) {
        // 1：构建图
        Graph graph = new Graph();
        graph.addVertex("网页基础");
        graph.addVertex("Java基础");
        graph.addVertex("JavaWeb");
        graph.addVertex("数据库");
        graph.addVertex("Spring框架");
        graph.addVertex("微服务框架");
        graph.addVertex("实战项目");

        // 添加边
        graph.addEdge("网页基础", "JavaWeb");
        graph.addEdge("Java基础", "JavaWeb");
        graph.addEdge("数据库", "Spring框架");
        graph.addEdge("JavaWeb", "Spring框架");
        graph.addEdge("Spring框架", "微服务框架");
        graph.addEdge("微服务框架", "实战项目");
        // graph.addEdge("实战项目", "微服务框架");  // 创建环的代码

        TS(graph);


    }
}
