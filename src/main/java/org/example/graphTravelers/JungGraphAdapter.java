package org.example.graphTravelers;

import edu.uci.ics.jung.graph.SparseMultigraph;

import java.util.HashSet;
import java.util.Set;

public class JungGraphAdapter implements GraphAdapter{
    private final SparseMultigraph<Integer, String> jungGraph;

    public JungGraphAdapter(SparseMultigraph<Integer, String> jungGraph) {
        this.jungGraph = jungGraph;
    }

    @Override
    public Set<Integer> getNeighbors(Integer vertex) {
        return new HashSet<>(jungGraph.getNeighbors(vertex));
    }
}
