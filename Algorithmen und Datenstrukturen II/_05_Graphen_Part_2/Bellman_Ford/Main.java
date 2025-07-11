package _05_Graphen_Part_2.Bellman_Ford;

public class Main {
    public static void main(String[] args) {
        int V = 5;
        int E = 8;
        BellmanFord graph = new BellmanFord(V, E);

        // Define edges
        // Edge 0-1
        graph.edge[0].source = 0;
        graph.edge[0].destination = 1;
        graph.edge[0].weight = -1;

        // Edge 0-2
        graph.edge[1].source = 0;
        graph.edge[1].destination = 2;
        graph.edge[1].weight = 4;

        // Edge 1-2
        graph.edge[2].source = 1;
        graph.edge[2].destination = 2;
        graph.edge[2].weight = 3;

        // Edge 1-3
        graph.edge[3].source = 1;
        graph.edge[3].destination = 3;
        graph.edge[3].weight = 2;

        // Edge 1-4
        graph.edge[4].source = 1;
        graph.edge[4].destination = 4;
        graph.edge[4].weight = 2;

        // Edge 3-2
        graph.edge[5].source = 3;
        graph.edge[5].destination = 2;
        graph.edge[5].weight = 5;

        // Edge 3-1
        graph.edge[6].source = 3;
        graph.edge[6].destination = 1;
        graph.edge[6].weight = 1;

        // Edge 4-3
        graph.edge[7].source = 4;
        graph.edge[7].destination = 3;
        graph.edge[7].weight = -3;

        // Execute Bellman-Ford algorithm
        graph.bellmanFordAlgo(graph, 0);
    }
}

