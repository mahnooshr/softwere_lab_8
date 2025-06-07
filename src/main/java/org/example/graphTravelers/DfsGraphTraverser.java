package org.example.graphTravelers;

import edu.uci.ics.jung.graph.SparseMultigraph;

import java.util.*;

public class DfsGraphTraverser implements Traverser {
    private final GraphAdapter graph; //removing the dependency to the jung library
//    private final SparseMultigraph<Integer, String> graph;

    public DfsGraphTraverser(GraphAdapter graph) {
        this.graph = graph;
    }

    @Override
    public List<Integer> traverse(Integer startVertex) {
        List<Integer> result = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        Stack<Integer> stack = new Stack<>();

        stack.push(startVertex);

        while (!stack.isEmpty()) {
            Integer vertex = stack.pop();
            if (!visited.contains(vertex)) {
                visited.add(vertex);
                result.add(vertex);

                // Get neighbors and sort them for deterministic output
                List<Integer> neighbors = new ArrayList<>(graph.getNeighbors(vertex));
                neighbors.sort(Integer::compareTo); // ترتیب صعودی همسایگان

                for (Integer neighbor : neighbors) {
                    if (!visited.contains(neighbor)) {
                        stack.push(neighbor);
                    }
                }
            }
        }
        return result;
    }
}