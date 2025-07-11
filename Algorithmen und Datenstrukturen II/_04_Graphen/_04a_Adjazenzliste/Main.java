package _04_Graphen._04a_Adjazenzliste;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        Map<String, List<String>> am = new HashMap<>();

        Graph.addEdge(am, "A", "B");
        Graph.addEdge(am, "A", "E");
        Graph.addEdge(am, "A", "F");

        Graph.addEdge(am, "B", "C");
        Graph.addEdge(am, "B", "D");
        Graph.addEdge(am, "B", "F");

        Graph.addEdge(am, "C", "B");
        Graph.addEdge(am, "C", "D");
        Graph.addEdge(am, "C", "F");

        Graph.addEdge(am, "D", "B");
        Graph.addEdge(am, "D", "C");
        Graph.addEdge(am, "D", "E");

        Graph.addEdge(am, "E", "A");
        Graph.addEdge(am, "E", "B");
        Graph.addEdge(am, "E", "D");

        Graph.addEdge(am, "F", "C");
        Graph.addEdge(am, "F", "D");
        Graph.addEdge(am, "F", "E");

        for(Map.Entry<String, List<String>> entry : am.entrySet()) {
            System.out.print("Vertex " + entry.getKey() + ": ");

            List<String> list = entry.getValue();

            for (String s : list) {
                System.out.print(s + " ");
            }
            System.out.println();
        }


        // Only for Integers:
        //int V = 5;
        //ArrayList<ArrayList<Integer>> am = new ArrayList<>(V);

        /*for (int i = 0; i < V; i++) {
            am.add(new ArrayList<>());
        }
        Graph.addEdge(am, 0, 1);
        Graph.addEdge(am, 0, 2);
        Graph.addEdge(am, 0, 3);
        Graph.addEdge(am, 1,2);

        for (int i = 0; i < am.size(); i++) {
            System.out.print("Vertex " + i + ":");
            for (Integer integer : am.get(i)) {
                System.out.print(" " + integer);
            }
            System.out.println();
        }

         */
    }
}
