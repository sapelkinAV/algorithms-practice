package com.sapelkinav.graphs;

import com.AlgorithmRunner;
import org.graalvm.collections.Pair;

import java.util.*;

public class UndirectedGraph implements AlgorithmRunner {

    List<Pair<String, String>> edges = List.of(
            Pair.create("i", "j"),
            Pair.create("k", "i"),
            Pair.create("m", "k"),
            Pair.create("k", "l"),
            Pair.create("o", "n")
    );

    @Override
    public void runAlgorithm() {
        var graph = buildGraph(edges);
        System.out.println(hasPath(graph, "i", "k", new HashSet<>()));
    }

    private Map<String, List<String>> buildGraph(List<Pair<String, String>> edges) {
        Map<String, List<String>> graph = new HashMap<>();
        for (var edge : edges) {
            if (!graph.containsKey(edge.getLeft())) {
                graph.put(edge.getLeft(), new ArrayList<>());
            }
            if (!graph.containsKey(edge.getRight())) {
                graph.put(edge.getRight(), new ArrayList<>());
            }

            graph.get(edge.getLeft()).add(edge.getRight());
            graph.get(edge.getRight()).add(edge.getLeft());
        }
        return graph;
    }

    private boolean hasPath(Map<String, List<String>> graph, String src, String dst, Set<String> visited) {
        if (Objects.equals(src, dst)) {
            return true;
        }
        if (visited.contains(src)) return false;
        visited.add(src);


        for (var neighbour : graph.get(src)) {
            if (hasPath(graph, neighbour, dst, visited)) {
                return true;
            }
        }
        return false;
    }
}
