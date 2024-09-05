package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GraphAdjList {
    Map<Vertex, List<Vertex>> adjList;

    public GraphAdjList(Vertex[][] edges) {
        adjList = new HashMap<>();
        for (Vertex[] edge : edges) {
            addVertex(edge[0]);
            addVertex(edge[1]);
            addEdge(edge[0], edge[1]);
        }
    }

    public int size() {
        return adjList.size();
    }

    public void addEdge(Vertex vet1, Vertex vet2) {
        if (!adjList.containsKey(vet1) || !adjList.containsKey(vet2) || vet1 == vet2)
            throw new IllegalArgumentException();
        adjList.get(vet1).add(vet2);
        adjList.get(vet2).add(vet1);
    }

    public void removeEdge(Vertex vet1, Vertex vet2) {
        if (!adjList.containsKey(vet1) || !adjList.containsKey(vet2) || vet1 == vet2)
            throw new IllegalArgumentException();
        adjList.get(vet1).remove(vet2);
        adjList.get(vet2).remove(vet1);
    }

    public void addVertex(Vertex vet) {
        if (adjList.containsKey(vet))
            return;
        adjList.put(vet, new ArrayList<>());
    }

    public void removeVertex(Vertex vet) {
        if (!adjList.containsKey(vet))
            return;
        adjList.remove(vet);
        for (List<Vertex> list : adjList.values()) {
            list.remove(vet);
        }
    }

    public void print() {
        for (Map.Entry<Vertex, List<Vertex>> pair : adjList.entrySet()) {
            List<Integer> tmp = new ArrayList<>();
            for (Vertex vertex : pair.getValue())
                tmp.add(vertex.val);
            System.out.println(pair.getKey().val + ": " + tmp + ",");
        }
    }

    public static void main(String[] args) {
        Vertex v0 = new Vertex(0);
        Vertex v1 = new Vertex(1);
        Vertex v2 = new Vertex(2);
        Vertex v3 = new Vertex(3);
        Vertex[][] edges = {
                {v0, v1},
                {v1, v2},
                {v2, v3},
                {v3, v0}
        };
        GraphAdjList graph = new GraphAdjList(edges);
        graph.print();
//        1: [0, 2],
//        3: [2, 0],
//        2: [1, 3],
//        0: [1, 3],
    }
}
