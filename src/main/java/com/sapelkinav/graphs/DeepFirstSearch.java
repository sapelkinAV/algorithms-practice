package com.sapelkinav.graphs;

import com.AlgorithmRunner;

import java.util.List;
import java.util.Map;
import java.util.Stack;

public class DeepFirstSearch implements AlgorithmRunner {
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
        dfsPrint(graph, "a");
    }

    private void dfsPrint(Map<String, List<String>> graph, String source) {
        var stack = new Stack<String>();
        stack.add(source);
        while (!stack.isEmpty()) {
            var current = stack.pop();
            System.out.println(current);
            stack.addAll(graph.get(current));
        }

    }

    private void dfsRecursive(Map<String, List<String>> graph, String source) {
        System.out.println(source);
        var neighbours = graph.get(source);
        neighbours.forEach(el -> dfsRecursive(graph, el));
    }
}
