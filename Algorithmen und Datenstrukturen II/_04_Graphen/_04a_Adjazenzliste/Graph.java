package _04_Graphen._04a_Adjazenzliste;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Graph {
    // Add Edge → only works mit Integers
    public static void addEdge(ArrayList<ArrayList<Integer>> am, int s, int d) {
        am.get(s).add(d);
        am.get(d).add(s);
    }

    // Add Edge -> Strings
    public static void addEdge(Map<String, List<String>> adjacencyList, String u, String v) {
        //adjacencyList.putIfAbsent(u, new ArrayList<>());
       // adjacencyList.get(u).add(v);
        adjacencyList.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
        //adjacencyList.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
    }
}
