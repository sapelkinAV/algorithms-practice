package com.sapelkinav.graphs;

import com.AlgorithmRunner;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class HasPath implements AlgorithmRunner {

    private Map<String, List<String>> graph = Map.of(
            "a", List.of("b", "c"),
            "b", List.of("d"),
            "c", List.of("e"),
            "d", List.of("f"),
            "e", List.of(),
            "f", List.of()
    );

    private boolean hasPah(Map<String, List<String>> graph, String src, String dst){
        if (src.equals(dst)) {
            return true;
        }
        for (var neighbour : graph.get(src)) {
            if(hasPah(graph, neighbour, dst)){
                return true;
            }
        }
        return false;
    }

    private boolean hasPathBreadthFirst(Map<String, List<String>> graph, String src, String dst) {
        Queue<String> queue = new LinkedList<>();
        queue.add(src);
        while (!queue.isEmpty()) {
            var current = queue.remove();
            if (current == dst) return true;

            for (var neighbour : graph.get(current)) {
                queue.add(neighbour);
            }
        }
        return false;
    }

    @Override
    public void runAlgorithm() {
        System.out.println(hasPah(graph, "a", "f"));
        System.out.println(hasPah(graph, "f", "e"));

        System.out.println(hasPathBreadthFirst(graph, "a", "f"));
        System.out.println(hasPathBreadthFirst(graph, "f", "e"));
    }
}
