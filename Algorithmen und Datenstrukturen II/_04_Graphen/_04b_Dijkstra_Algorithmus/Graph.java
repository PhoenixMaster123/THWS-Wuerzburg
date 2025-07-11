package _04_Graphen._04b_Dijkstra_Algorithmus;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Graph {
    public static void addEdge(Map<String, Map<String, Integer>> adjacencyList, String u, String v, Integer value) {
        adjacencyList.computeIfAbsent(u, h -> new HashMap<>()).put(v, value);
        adjacencyList.computeIfAbsent(v, h -> new HashMap<>()).put(u, value); // Add the reverse edge
    }
    public static Map<String, Integer> dijkstra(Map<String, Map<String, Integer>> graph, String startNode) {
        Map<String, Integer> distances = new HashMap<>();
        Map<String, String> previousNodes = new HashMap<>(); // To track the path

        for (String node : graph.keySet()) {
            distances.put(node, Integer.MAX_VALUE); // Initialize distances with infinity
        }
        distances.put(startNode, 0); // Distance to start node is zero

        PriorityQueue<String> queue = new PriorityQueue<>(Comparator.comparingInt(distances::get));
        queue.add(startNode);

        while (!queue.isEmpty()) {
            String currentNode = queue.poll();
            int currentDistance = distances.get(currentNode);

            // Explore neighbors
            for (Map.Entry<String, Integer> neighbor : graph.get(currentNode).entrySet()) {
                String neighborNode = neighbor.getKey();
                int weight = neighbor.getValue();
                int distance = currentDistance + weight;

                // If a shorter path is found
                if (distance < distances.get(neighborNode)) {
                    distances.put(neighborNode, distance);
                    previousNodes.put(neighborNode, currentNode); // Update the previous node
                    queue.add(neighborNode);
                }
            }
        }

        // After Dijkstra's algorithm, retrieve the shortest path from A to F
        System.out.println("Shortest path from A to F:");
        printPath(previousNodes, "F");

        return distances;
    }
    private static void printPath(Map<String, String> previousNodes, String endNode) {
        StringBuilder path = new StringBuilder();
        for (String at = endNode; at != null; at = previousNodes.get(at)) {
            path.insert(0, at + " "); // Insert at the beginning
        }
        System.out.println(path.toString().trim()); // Trim to remove trailing space
    }
}
