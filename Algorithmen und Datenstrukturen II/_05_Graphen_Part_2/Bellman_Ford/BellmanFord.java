package _05_Graphen_Part_2.Bellman_Ford;

import java.util.Arrays;

public class BellmanFord {

    int V, E; // (V = vertices | E = edges)
    Edge[] edge;

    public BellmanFord(int v, int e) {
        this.V = v;
        this.E = e;
        edge = new Edge[e];

        for (int i = 0; i < e; i++) {
            edge[i] = new Edge();
        }
    }

    public void bellmanFordAlgo(BellmanFord graph, int source) {
        int V = graph.V;
        int E = graph.E;
        int[] dist = new int[V];

        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[source] = 0;

        // Step 2: Relax all edges |V| - 1 times.
        for (int i = 1; i < V; ++i) {
            for (int j = 0; j < E; ++j) {
                int u = graph.edge[j].source;
                int v = graph.edge[j].destination;
                int weight = graph.edge[j].weight;
                if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v])
                    dist[v] = dist[u] + weight;
            }
        }

        // Step 3: Check for negative-weight cycles
        for (int j = 0; j < E; ++j) {
            int u = graph.edge[j].source;
            int v = graph.edge[j].destination;
            int weight = graph.edge[j].weight;
            if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) {
                System.out.println("Graph contains negative weight cycle");
                return;
            }
        }

        printDistances(dist, V);
    }
    // Print distances from source to all vertices
    void printDistances(int[] dist, int V) {
        System.out.println("Vertex Distance from Source:");
        for (int i = 0; i < V; ++i)
            System.out.println(i + "\t\t" + dist[i]);
    }
}
