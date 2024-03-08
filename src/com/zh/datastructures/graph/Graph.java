package com.zh.datastructures.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-03-07 15:48
 * @description: 图的Java实现
 **/
public class Graph {
    /*
        图有两种方式，一个是邻接矩阵、一个是邻接表，一般都使用邻接表表示。明确图的内部类和内部类相关属性（有向图）
        节点 Vertex
            name：节点名
            edges：关联的边
            isVisited：是否被访问（help traversal）
        Edge
            linked：连接的顶点
            height：权重
         这里采用添加边的时候跟节点关联。不必添加完节点以后手动赋值edges了（两者都是通过节点名先创建接节点再考虑edges的问题）
     */

    public Map<String, Vertex> vertices;   // 存储图的所有节点

    // 无参构造
    public Graph() {
        this.vertices = new HashMap<>();
    }

    public class Vertex {
        public String name;    // 节点名
        public List<Edge> edges;   // 边的集合
        public Boolean isVisited = false;

        public int inDegree = 0;  // 入度——拓扑排序

        public int status = 0;  // 0未访问 1访问中 2访问完成   拓扑排序中用于DFS算法判断是否存在环

        public int dist = 0;    // 路径算法中到该节点的距离

        public Vertex(String name, List<Edge> edges) {
            this.name = name;
            this.edges = edges;
        }

        public Vertex(String name) {
            this.name = name;
        }
    }

    public class Edge {
        public Vertex linked;  // 边连接的顶点
        public int height; // 边的权重

        public Edge(Vertex linked, int height) {
            this.linked = linked;
            this.height = height;
        }

        public Edge(Vertex linked) {
            this.linked = linked;
        }
    }

    // 添加节点
    public void addVertex(String name) {
        vertices.put(name, new Vertex(name, new ArrayList<>()));
    }

    /**
     * @param from   边的起始节点的名称（边要知道节点）
     * @param to     边的指向节点的名称
     * @param height 边的权重
     * @return void
     * @author AlbertZhang
     * @description 添加边
     * @date 2024-03-07 16:44
     **/
    public void addEdge(String from, String to, int height) {
        Vertex fromVertex = vertices.get(from);
        Vertex toVertex = vertices.get(to);

        if (fromVertex != null && toVertex != null) {
            fromVertex.edges.add(new Edge(toVertex, height));
        }
    }

    /**
     * @param from 边的起始节点的名称
     * @param to   边的结束节点的名称
     * @return void
     * @author AlbertZhang
     * @description 添加不含权重的边
     * @date 2024-03-08 17:54
     **/
    public void addEdge(String from, String to) {
        Vertex fromVertex = vertices.get(from);
        Vertex toVertex = vertices.get(to);

        if (fromVertex != null && toVertex != null) {
            fromVertex.edges.add(new Edge(toVertex));
        }
    }

    /**
     * @param key 头结点的名称
     * @return com.zh.datastructures.graph.Graph.Vertex 头节点本身
     * @author AlbertZhang
     * @description 获取图的头节点
     * @date 2024-03-08 13:37
     **/
    public Vertex getHeadV(String key) {
        return vertices.get(key);
    }


}
