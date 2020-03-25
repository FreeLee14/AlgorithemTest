package com.zrwang.test.graph;

import com.zrwang.algorithmtest.graph.Graph;
import com.zrwang.algorithmtest.graph.Vertex;

import java.util.Arrays;

//图的测试
public class GraphTest {

    public static void main(String[] args) {

        Graph graph = new Graph(5);

        Vertex v1 = new Vertex("A");
        Vertex v2 = new Vertex("B");
        Vertex v3 = new Vertex("C");
        Vertex v4 = new Vertex("D");
        Vertex v5 = new Vertex("E");

        graph.addVertex(v1);
        graph.addVertex(v2);
        graph.addVertex(v3);
        graph.addVertex(v4);
        graph.addVertex(v5);

        graph.addEdge("A","B");
        graph.addEdge("B","C");
        graph.addEdge("A","C");
        graph.addEdge("B","D");
        graph.addEdge("B","E");

        for (int[] a: graph.adjMat){
            System.out.println(Arrays.toString(a));
        }

        graph.bfs();

    }
}
