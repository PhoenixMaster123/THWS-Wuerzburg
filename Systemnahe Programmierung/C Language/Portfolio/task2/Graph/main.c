#include <stdio.h>
#include <stdlib.h>

typedef struct node {
    int dest;
    struct node *next;
} Node;

void insertEdge(Node **head, int dest);
void deleteEdge(Node **head, int dest);
void depthSearch(Node **adjList, int start, int numNodes, int *visited);
void displayEdges(Node **adjList, int numNodes);

// Adjacency List
int main(void) {
    int numNodes = 5;
    Node *adjList[numNodes]; // Array of pointers for adjacency list

    // Initialize adjacency list
    for (int i = 0; i < numNodes; i++) {
        adjList[i] = NULL;
    }

    // Add edges (Example: 0 -> 1, 1 -> 2, 2 -> 3, etc.)
    insertEdge(&adjList[0], 1);
    insertEdge(&adjList[1], 2);
    insertEdge(&adjList[2], 3);
    insertEdge(&adjList[3], 4);

    // Display adjacency list
    printf("Graph adjacency list:\n");
    displayEdges(adjList, numNodes);

    // Perform depth-first search from node 0
    int visited[numNodes];
    for (int i = 0; i < numNodes; i++) visited[i] = 0; // Initialize visited array

    printf("\nDepth-First Search starting from node 0:\n");
    depthSearch(adjList, 0, numNodes, visited);

    // Delete an edge and display the graph again
    printf("\n\nDeleting edge 0 -> 1\n");
    deleteEdge(&adjList[0], 1);
    displayEdges(adjList, numNodes);

    return 0;
}

void insertEdge(Node **head, int dest) {
    Node *newNode = (Node *)malloc(sizeof(Node));
    newNode->dest = dest;
    newNode->next = *head;
    *head = newNode;
}

void deleteEdge(Node **head, int dest) {
    Node *temp = *head, *prev = NULL;

    // Find the edge to delete
    while (temp != NULL && temp->dest != dest) {
        prev = temp;
        temp = temp->next;
    }

    if (temp == NULL) {
        printf("Edge not found.\n");
        return; // Edge does not exist
    }

    // Remove the edge
    if (prev == NULL) {
        *head = temp->next; // Remove the first node
    } else {
        prev->next = temp->next; // Remove a middle or last node
    }

    free(temp);
}

void depthSearch(Node **adjList, int start, int numNodes, int *visited) {
    // Mark the current node as visited and print it
    visited[start] = 1;
    printf("%d ", start);

    // Traverse all neighbors of the current node
    Node *temp = adjList[start];
    while (temp != NULL) {
        if (!visited[temp->dest]) {
            depthSearch(adjList, temp->dest, numNodes, visited);
        }
        temp = temp->next;
    }
}

void displayEdges(Node **adjList, int numNodes) {
    for (int i = 0; i < numNodes; i++) {
        printf("Node %d: ", i);
        Node *temp = adjList[i];
        while (temp != NULL) {
            printf("-> %d ", temp->dest);
            temp = temp->next;
        }
        printf("\n");
    }
}
