package com.my;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Алгоритм поиска в ширину
public class BFSSort {
    public static void main(String[] args) {
        Map<String, List<String>> graph = new HashMap<>();
        graph.put("I", List.of("Bob", "Alice"));
        graph.put("Bob", List.of("Patrick", "Jenny"));
        graph.put("Alice", List.of("Patrick", "Heather"));
        graph.put("Patrick", List.of("John"));

        search(graph, "I", "John");
    }

    private static void search(Map<String, List<String>> graph, String startFrom, String targetPerson) {
        List<String> visited = new ArrayList<>();

        Deque<String> searchQueue = new ArrayDeque<>(graph.get(startFrom));
        while (!searchQueue.isEmpty()) {
            String person = searchQueue.pollFirst();
            if (!visited.contains(person)) {
                if (person.equals(targetPerson)) {
                    System.out.println("Found person: " + targetPerson);
                    return;
                }

                visited.add(person);
                searchQueue.addAll(graph.get(person) == null ? List.of() : graph.get(person));
                System.out.println("Checked person: " + person);
            }
        }
        System.out.println("Person was not found: " + targetPerson);
    }

}
