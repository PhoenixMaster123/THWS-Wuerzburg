#include <stdio.h>
#include <stdlib.h>

// Definition eines Knotens für die Adjazenzliste
struct Node {
    int vertex;
    struct Node* next;
};

// Definition des Graphen
struct Graph {
    int numVertices;
    struct Node** adjLists;
};

// Funktion zum Erstellen eines neuen Knotens
struct Node* createNode(int vertex) {
    struct Node* newNode = (struct Node*)malloc(sizeof(struct Node));
    newNode->vertex = vertex;
    newNode->next = NULL;
    return newNode;
}

// Funktion zum Erstellen eines Graphen
struct Graph* createGraph(int vertices) {
    struct Graph* graph = (struct Graph*)malloc(sizeof(struct Graph));
    graph->numVertices = vertices;

    // Erstellen der Adjazenzlisten
    graph->adjLists = (struct Node**)malloc(vertices * sizeof(struct Node*));
    for (int i = 0; i < vertices; i++) {
        graph->adjLists[i] = NULL;
    }
    return graph;
}

// Funktion zum Hinzufügen einer Kante zum Graphen
void addEdge(struct Graph* graph, int src, int dest) {
    // Kante von src nach dest hinzufügen
    struct Node* newNode = createNode(dest);
    newNode->next = graph->adjLists[src];
    graph->adjLists[src] = newNode;

    // Kante von dest nach src hinzufügen (für ungerichteten Graphen)
    newNode = createNode(src);
    newNode->next = graph->adjLists[dest];
    graph->adjLists[dest] = newNode;
}

// Funktion für die Tiefensuche (DFS)
void DFS(struct Graph* graph, int vertex, int* visited) {
    visited[vertex] = 1;
    printf("%d ", vertex);
    struct Node *temp = graph->adjLists[vertex];
    while (temp != NULL) {
        if (!visited[temp->vertex]) {
            DFS(graph, temp->vertex, visited);
        }
        temp = temp->next;
    }
    printf("\n");
}

// Hauptfunktion zum Testen des Graphen
int main() {
    struct Graph* graph = createGraph(5);

    // Kanten zum Graphen hinzufügen
    addEdge(graph, 0, 1);
    addEdge(graph, 0, 4);
    addEdge(graph, 1, 2);
    addEdge(graph, 1, 3);
    addEdge(graph, 1, 4);
    addEdge(graph, 2, 3);
    addEdge(graph, 3, 4);

    // Tiefensuche durchführen
    int visited[5] = {0}; // Array zur Verfolgung besuchter Knoten
    printf("Tiefensuche (DFS): ");
    DFS(graph, 0, visited);
    printf("\n");

    return 0;
}