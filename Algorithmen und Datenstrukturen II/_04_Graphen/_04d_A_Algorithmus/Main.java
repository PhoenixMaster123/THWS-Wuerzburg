package _04_Graphen._04d_A_Algorithmus;

import java.util.*;

class Node implements Comparable<Node> {
    String name;
    int g; // Actual cost from the start node
    int h; // Heuristic estimate to the target
    int f; // f = g + h
    Node parent; // To track the path

    public Node(String name, int g, int h) {
        this.name = name;
        this.g = g;
        this.h = h;
        this.f = g + h;
    }

    @Override
    public int compareTo(Node other) {
        return Integer.compare(this.f, other.f);
    }

    @Override
    public String toString() {
        return name;
    }
}

public class Main {
    // Define heuristic (H) values for each node
    private static final Map<String, Integer> heuristic = Map.of(
            "A", 317, "B", 211, "C", 165, "D", 161,
            "E", 112, "F", 57, "G", 157, "H", 0
    );

    // Define the graph as an adjacency map with edge costs
    private static final Map<String, Map<String, Integer>> graph = Map.of(
            "A", Map.of("B", 112, "D", 153),
            "B", Map.of("E", 98, "C", 62),
            "C", Map.of("F", 116),
            "D", Map.of( "E", 63, "G", 51),
            "E", Map.of("F", 59),
            "F", Map.of("H", 53),
            "G", Map.of("H", 163),
            "H", Map.of()
    );

    // Method to print the graph
    public static void printGraph() {
        System.out.println("Graph (Adjacency List):");
        for (Map.Entry<String, Map<String, Integer>> entry : graph.entrySet()) {
            String node = entry.getKey();
            Map<String, Integer> neighbors = entry.getValue();
            System.out.print(node + " -> ");
            for (Map.Entry<String, Integer> neighbor : neighbors.entrySet()) {
                System.out.print(neighbor.getKey() + "(" + neighbor.getValue() + ") ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static List<String> aStar(String startName, String targetName) {
        PriorityQueue<Node> openSet = new PriorityQueue<>();
        Map<String, Integer> gCosts = new HashMap<>();
        Map<String, Node> predecessors = new HashMap<>();

        Node start = new Node(startName, 0, heuristic.get(startName));
        openSet.add(start);
        gCosts.put(startName, 0);
        predecessors.put(startName, null);

        while (!openSet.isEmpty()) {
            Node current = openSet.poll();

            if (current.name.equals(targetName)) {
                return constructPath(predecessors, targetName);
            }

            for (Map.Entry<String, Integer> entry : graph.getOrDefault(current.name, new HashMap<>()).entrySet()) {
                String neighborName = entry.getKey();
                int cost = entry.getValue();
                int tentativeG = current.g + cost;

                if (!gCosts.containsKey(neighborName) || tentativeG < gCosts.get(neighborName)) {
                    gCosts.put(neighborName, tentativeG);
                    int h = heuristic.get(neighborName);
                    Node neighbor = new Node(neighborName, tentativeG, h);
                    openSet.add(neighbor);
                    predecessors.put(neighborName, current);
                }
            }
        }

        return null; // No path found
    }

    private static List<String> constructPath(Map<String, Node> predecessors, String targetName) {
        List<String> path = new ArrayList<>();
        Node at = predecessors.get(targetName);

        path.add(targetName); // Start with the target
        while (at != null) {
            path.add(at.name);
            at = predecessors.get(at.name);
        }

        Collections.reverse(path);
        return path;
    }

    public static void main(String[] args) {
        // Print the graph first
        printGraph();

        // Run A* algorithm from A to H
        String start = "A";
        String target = "H";
        List<String> path = aStar(start, target);

        if (path != null) {
            System.out.println("Shortest path from " + start + " to " + target + ": " + String.join(" -> ", path));
        } else {
            System.out.println("No path found.");
        }
    }
}
