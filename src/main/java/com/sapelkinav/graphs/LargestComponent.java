package com.sapelkinav.graphs;

import com.AlgorithmRunner;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LargestComponent implements AlgorithmRunner {
    private Map<Integer, List<Integer>> graph = Map.of(
            0, List.of(8, 1, 5),
            1, List.of(0),
            5, List.of(0, 8),
            8, List.of(0, 5),
            2, List.of(3, 4),
            3, List.of(2, 4),
            4, List.of(3, 2)
    );

    private Set<Integer> visited = new HashSet();


    @Override
    public void runAlgorithm() {
        System.out.println(largestCount(graph));
    }

    private int largestCount(Map<Integer, List<Integer>> graph) {
        int maxCount = 0;

        for (var node : graph.keySet()) {
            int currentComponentSize = exploreSize(graph, node);
            if (currentComponentSize > maxCount) {
                maxCount = currentComponentSize;
            }
        }
        return maxCount;

    }

    private int exploreSize(Map<Integer, List<Integer>> graph, Integer current) {
        if (visited.contains(current)) {
            return 0;
        }
        visited.add(current);
        int count = 1;

        for (var neighbour : graph.get(current)) {
            count+=exploreSize(graph, neighbour);
        }

        return count;
    }
}
