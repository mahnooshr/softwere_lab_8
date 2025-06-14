package org.example.graphTravelers;

import java.util.Set;

public interface GraphAdapter {
    Set<Integer> getNeighbors(Integer vertex);
}
