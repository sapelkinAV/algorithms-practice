package com.sapelkinav.graphs;

import com.AlgorithmRunner;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ConnectedComponents implements AlgorithmRunner {

    private Map<String, List<String>> graph = Map.of(
            "0", List.of("8", "1", "5"),
            "1", List.of("0"),
            "5", List.of("0", "8"),
            "8", List.of("0", "5"),
            "2", List.of("3", "4"),
            "3", List.of("2", "4"),
            "4", List.of("3", "2")
    );

    private Set<String> visited = new HashSet();


    @Override

    public void runAlgorithm() {
        System.out.println(componentCount(graph));
    }

    private int componentCount(Map<String, List<String>> graph) {
        int count = 0;

        for (var node : graph.keySet()) {
            if (explore(graph, node)) {
                count++;
            }
        }
        return count;
    }

    private boolean explore(Map<String, List<String>> graph, String current) {
        if (visited.contains(current)) {
            return false;
        }
        visited.add(current);

        for (var neighbour : graph.get(current)) {
            explore(graph, neighbour);
        }

        return true;
    }
}
