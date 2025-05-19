package com.my;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class Dijkstra {
    private static Map<String, Map<String, Integer>> graph = new HashMap<>();
    private static Map<String, Integer> costs = new HashMap<>();
    private static Map<String, String> parents = new HashMap<>();
    private static List<String> processed = new ArrayList<>();

    public static void main(String[] args) {
        graph.put("start", Map.of("A", 6, "B", 2));
        graph.put("A", Map.of("fin", 1));
        graph.put("B", Map.of("A", 3, "fin", 5));
        graph.put("fin", Map.of());

        costs.put("start", 0);
        costs.put("A", 6);
        costs.put("B", 2);
        costs.put("fin", Integer.MAX_VALUE);

        parents.put("start", null);
        parents.put("A", "start");
        parents.put("B", "start");
        parents.put("fin", null);

        updateCosts();
        printRoute("fin");
    }

    private static void updateCosts() {
        String node = findNodeWithLowestCost(costs, processed);
        while (node != null) {
            Map<String, Integer> neighbours = graph.get(node);
            for (Map.Entry<String, Integer> entry : neighbours.entrySet()) {
                String neighbourNode = entry.getKey();
                Integer neighbourWeight = entry.getValue();

                if (costs.get(node) + neighbourWeight < costs.get(neighbourNode)) {
                    costs.put(neighbourNode, costs.get(node) + neighbourWeight);
                    parents.put(neighbourNode, node);
                }
            }
            processed.add(node);
            node = findNodeWithLowestCost(costs, processed);
        }
    }

    private static String findNodeWithLowestCost(Map<String, Integer> costs, List<String> processed) {
        Integer minCost = Integer.MAX_VALUE;
        String nodeWithLowestCost = null;

        for (Map.Entry<String, Integer> entry : costs.entrySet()) {
            String node = entry.getKey();
            Integer nodeCost = entry.getValue();

            if (processed.contains(node)) {
                continue;
            }

            nodeWithLowestCost = node;
            if (nodeCost < minCost) {
                minCost = nodeCost;
            }
        }
        return nodeWithLowestCost;
    }

    private static void printRoute(String end) {
        Stack<String> route = new Stack<>();
        route.push(end);
        String parent = parents.get(end);
        while (parent != null) {
            route.push(parent);
            parent = parents.get(parent);
        }

        while (!route.isEmpty()) {
            System.out.print(route.pop());
            if (!route.isEmpty()) {
                System.out.print(" -> ");
            }
        }
    }
}
