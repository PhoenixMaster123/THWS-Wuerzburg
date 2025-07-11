package _04_Graphen._04b_Dijkstra_Algorithmus;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, Map<String, Integer>> adjacencyList = new HashMap<>();

        // Add edges to the graph
        Graph.addEdge(adjacencyList, "A", "B", 10);
        Graph.addEdge(adjacencyList, "A", "D", 5);

        Graph.addEdge(adjacencyList, "B", "D", 10);
        Graph.addEdge(adjacencyList, "B", "C", 10);
        Graph.addEdge(adjacencyList, "B", "E", 25);

        Graph.addEdge(adjacencyList, "D", "E", 25);

        Graph.addEdge(adjacencyList, "C", "F", 15);
        Graph.addEdge(adjacencyList, "C", "E", 5);

        Graph.addEdge(adjacencyList, "E", "F", 5);

        printGraph(adjacencyList);
        Graph.dijkstra(adjacencyList, "A");
    }
    private static void printGraph(Map<String, Map<String, Integer>> adjacencyList) {
        for (String node : adjacencyList.keySet()) {
            System.out.println("Node " + node + " has edges to:");
            for (Map.Entry<String, Integer> edge : adjacencyList.get(node).entrySet()) {
                System.out.println("  -> " + edge.getKey() + " with weight " + edge.getValue());
            }
        }
    }
}
