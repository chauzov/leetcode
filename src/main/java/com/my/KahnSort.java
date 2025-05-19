package com.my;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class KahnSort {
    public static void main(String[] args) {
        // Создаем граф (предметы -> их зависимости)
        Map<String, List<String>> graph = new HashMap<>();
        graph.put("Математика", Arrays.asList("Физика"));
        graph.put("Физика", Arrays.asList("Электродинамика", "Искусственный интеллект"));
        graph.put("Программирование", Arrays.asList("Алгоритмы"));
        graph.put("Алгоритмы", Arrays.asList("Искусственный интеллект"));
        graph.put("Электродинамика", new ArrayList<>());
        graph.put("Искусственный интеллект", new ArrayList<>());

        // Выполняем топологическую сортировку
        List<String> sortedCourses = topologicalSort(graph);
        System.out.println("Порядок изучения предметов: " + sortedCourses);
    }

    public static List<String> topologicalSort(Map<String, List<String>> graph) {
        // 1. Вычисляем входные степени
        Map<String, Integer> inDegree = new HashMap<>();
        for (String node : graph.keySet()) {
            inDegree.put(node, 0);
        }
        for (String node : graph.keySet()) {
            for (String neighbor : graph.get(node)) {
                inDegree.put(neighbor, inDegree.get(neighbor) + 1);
            }
        }

        // 2. Находим все вершины с входной степенью 0 и добавляем в очередь
        Queue<String> queue = new LinkedList<>();
        for (String node : inDegree.keySet()) {
            if (inDegree.get(node) == 0) {
                queue.offer(node);
            }
        }

        // 3. Выполняем топологическую сортировку
        List<String> sortedOrder = new ArrayList<>();
        while (!queue.isEmpty()) {
            String current = queue.poll();
            sortedOrder.add(current);

            // Убираем текущий предмет и уменьшаем входную степень его зависимостей
            for (String neighbor : graph.get(current)) {
                inDegree.put(neighbor, inDegree.get(neighbor) - 1);
                if (inDegree.get(neighbor) == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        // Проверяем на цикл (если не смогли обработать все вершины)
        if (sortedOrder.size() != graph.size()) {
            throw new RuntimeException("Граф содержит цикл, топологическая сортировка невозможна!");
        }

        return sortedOrder;
    }
}
