package org.example;

import edu.uci.ics.jung.graph.SparseMultigraph;
import org.example.graphTravelers.*;

import java.util.ArrayList;
import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        // Create a graph
//        SparseMultigraph<Integer,String> graph = new SparseMultigraph<>();

        Graph<Integer, DefaultEdge> graph = new SimpleGraph<>(DefaultEdge.class);

        // Add vertices (using Integer nodes)
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);
        graph.addVertex(4);
        graph.addVertex(5);

        // Add edges (using String identifiers)
//        graph.addEdge("E1", 1, 2); // Edge between Vertex 1 and Vertex 2
//        graph.addEdge("E2", 1, 3); // Edge between Vertex 1 and Vertex 3
//        graph.addEdge("E3", 2, 4); // Edge between Vertex 2 and Vertex 4
//        graph.addEdge("E4", 3, 5); // Edge between Vertex 3 and Vertex 5
//        graph.addEdge("E5", 4, 5); // Edge between Vertex 4 and Vertex 5

        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 5);
        graph.addEdge(4, 5);



//        GraphAdapter adapter = new JungGraphAdapter(graph);
        GraphAdapter adapter = new JGraphTGraphAdapter(graph);

        Traverser dfsGraphTraveler= new DfsGraphTraverser(adapter);
        Traverser bfsGraphTraveler= new BfsGraphTraverser(adapter);

        List<Integer> dfsPath = dfsGraphTraveler.traverse(1);
        List<Integer> bfsTraveler = bfsGraphTraveler.traverse(1);

        System.out.println("Graph-DFS From node 1 is : " + dfsPath);
        System.out.println("Graph-BFS From node 1 is : " + bfsTraveler);


    }
}