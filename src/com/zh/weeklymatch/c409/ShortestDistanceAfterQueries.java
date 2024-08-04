package com.zh.weeklymatch.c409;

import java.util.*;

/*
    拓扑排序，每次加上边就行了
 */
public class ShortestDistanceAfterQueries {
    static class Edge {
        int to, weight;
        Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < n - 1; i++) {
            graph.get(i).add(new Edge(i + 1, 1));
        }

        int[] result = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int u = queries[i][0];
            int v = queries[i][1];
            graph.get(u).add(new Edge(v, 1));
            result[i] = dijkstra(graph, 0, n - 1, n);
        }

        return result;
    }

    private int dijkstra(List<List<Edge>> graph, int start, int end, int n) {
        int[] distances = new int[n];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[start] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.add(new int[] {start, 0});

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int currentNode = current[0];
            int currentDistance = current[1];

            if (currentDistance > distances[currentNode]) {
                continue;
            }

            for (Edge edge : graph.get(currentNode)) {
                int newDist = currentDistance + edge.weight;
                if (newDist < distances[edge.to]) {
                    distances[edge.to] = newDist;
                    pq.add(new int[] {edge.to, newDist});
                }
            }
        }

        return distances[end];
    }
}
