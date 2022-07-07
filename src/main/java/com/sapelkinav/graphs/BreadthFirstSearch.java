package com.sapelkinav.graphs;

import com.AlgorithmRunner;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class BreadthFirstSearch implements AlgorithmRunner {
    private Map<String, List<String>> graph = Map.of(
            "a", List.of("b", "c"),
            "b", List.of("d"),
            "c", List.of("e"),
            "d", List.of("f"),
            "e", List.of(),
            "f", List.of()
    );

    @Override
    public void runAlgorithm() {
        bfs(graph, "a");
    }

    private void bfs(Map<String, List<String>> graph, String source) {
        Queue<String> queue = new LinkedList<>();
        queue.add(source);
        while (!queue.isEmpty()) {
            var current = queue.remove();
            System.out.println(current);
            var neighbours = graph.get(current);
            queue.addAll(neighbours);
        }
    }
}
