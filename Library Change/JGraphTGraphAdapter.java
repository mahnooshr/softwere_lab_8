package org.example.graphTravelers;

import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultEdge;

import java.util.HashSet;
import java.util.Set;

public class JGraphTGraphAdapter implements GraphAdapter {
    private final Graph<Integer, DefaultEdge> jGraphTGraph;

    public JGraphTGraphAdapter(Graph<Integer, DefaultEdge> jGraphTGraph) {
        this.jGraphTGraph = jGraphTGraph;
    }

    @Override
    public Set<Integer> getNeighbors(Integer vertex) {
        Set<Integer> neighbors = new HashSet<>();
        for (DefaultEdge edge : jGraphTGraph.edgesOf(vertex)) {
            Integer source = jGraphTGraph.getEdgeSource(edge);
            Integer target = jGraphTGraph.getEdgeTarget(edge);
            if (source.equals(vertex)) {
                neighbors.add(target);
            } else {
                neighbors.add(source);
            }
        }
        return neighbors;
    }
}
