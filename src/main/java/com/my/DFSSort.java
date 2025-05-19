package com.my;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DFSSort {
    public static void main(String[] args) {
        // Создаем граф (предметы -> их зависимости)
        Map<String, List<String>> graph = new HashMap<>();
        graph.put("Математика", Arrays.asList("Физика"));
        graph.put("Физика", Arrays.asList("Электродинамика", "Искусственный интеллект"));
        graph.put("Программирование", Arrays.asList("Алгоритмы"));
        graph.put("Алгоритмы", Arrays.asList("Искусственный интеллект"));
        graph.put("Электродинамика", new ArrayList<>());
        graph.put("Искусственный интеллект", new ArrayList<>());

        // Выполняем топологическую сортировку (DFS)
        List<String> sortedCourses = topologicalSort(graph);
        System.out.println("Порядок изучения предметов: " + sortedCourses);
    }

    public static List<String> topologicalSort(Map<String, List<String>> graph) {
        Set<String> visited = new HashSet<>();
        Deque<String> stack = new ArrayDeque<>();
        Set<String> visiting = new HashSet<>(); // Для обнаружения циклов

        for (String node : graph.keySet()) {
            if (!visited.contains(node)) {
                if (!dfs(node, graph, visited, visiting, stack)) {
                    throw new RuntimeException("Граф содержит цикл! Топологическая сортировка невозможна.");
                }
            }
        }

        // Выгружаем вершины из стека в список (результат в нужном порядке)
        List<String> sortedOrder = new ArrayList<>(stack);
        Collections.reverse(sortedOrder); // Инвертируем, так как стек хранил в обратном порядке
        return sortedOrder;
    }

    private static boolean dfs(String node,
                               Map<String, List<String>> graph,
                               Set<String> visited,
                               Set<String> visiting,
                               Deque<String> stack) {
        if (visiting.contains(node)) {
            return false; // Обнаружен цикл!
        }

        if (visited.contains(node)) {
            return true; // Уже обработан
        }

        visiting.add(node); // Помечаем как обрабатываемый

        for (String neighbor : graph.get(node)) {
            if (!dfs(neighbor, graph, visited, visiting, stack)) {
                return false;
            }
        }

        visiting.remove(node);
        visited.add(node);
        stack.push(node); // Добавляем в стек после обработки всех зависимостей
        return true;
    }
}
