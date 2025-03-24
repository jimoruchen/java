package DS;

import java.util.ArrayList;
import java.util.List;

public class GraphAdjMat {
    List<Integer> vertices;
    List<List<Integer>> adjMat;

    public GraphAdjMat(int[] vertices, int[][] edges) {
        this.vertices = new ArrayList<>();
        this.adjMat = new ArrayList<>();
        for (int val : vertices)
            addVertex(val);
        for (int[] e : edges)
            addEdge(e[0], e[1]);
    }

    public int size() {
        return vertices.size();
    }

    public void addVertex(int val) {
        int n = size();
        vertices.add(val);
        List<Integer> newRow = new ArrayList<>(n);
        for (int j = 0; j < n; j++) {
            newRow.add(0);
        }
        adjMat.add(newRow);
        for (List<Integer> row : adjMat)
            row.add(0);
    }

    public void addEdge(int i, int j) {
        if (i < 0 || j < 0 || i >= size() || j >= size() ||i == j)
            throw new IndexOutOfBoundsException();
        adjMat.get(i).set(j, 1);
        adjMat.get(j).set(i, 1);
    }

    public void removeVertex(int index) {
        if (index >= size())
            throw new IndexOutOfBoundsException();
        vertices.remove(index);
        adjMat.remove(index);
        for (List<Integer> row : adjMat)
            row.remove(index);
    }

    public void removeEdge(int i, int j) {
        if (i < 0 || j < 0 || i >= size() || j >= size() ||i == j)
            throw new IndexOutOfBoundsException();
        adjMat.get(i).set(j, 0);
        adjMat.get(j).set(i, 0);
    }

    public void print() {
        System.out.println("顶点列表:");
        System.out.println(vertices);
        System.out.println("邻接矩阵:");
        for (List<Integer> row : adjMat)
            System.out.println(row);
    }

    public static void main(String[] args) {
        int[] vertices = {1, 2, 3, 4};
        int[][] edges = {
                {0, 1},
                {1, 2},
                {2, 3},
                {3, 0}
        };
        GraphAdjMat graph = new GraphAdjMat(vertices, edges);
        //graph.removeVertex(0);
        //graph.removeEdge(0, 1);
        graph.print();
//        顶点列表:
//        [1, 2, 3, 4]
//        邻接矩阵:
//        [0, 1, 0, 1]
//        [1, 0, 1, 0]
//        [0, 1, 0, 1]
//        [1, 0, 1, 0]
    }
}
