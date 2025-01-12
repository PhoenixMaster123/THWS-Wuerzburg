#include <stdio.h>
#include <stdlib.h>

// Struktur für einen Queue-Knoten
typedef struct Node {
    int data;
    struct Node* next;
} Node;

// Struktur für die Queue
typedef struct Queue {
    Node* front;
    Node* rear;
} Queue;

// Funktion, um eine neue Queue zu erstellen
Queue* createQueue() {
    Queue* q = (Queue*)malloc(sizeof(Queue));
    q->front = q->rear = NULL;
    return q;
}

// Funktion, um ein Element in die Queue einzufügen
void enqueue(Queue* q, int value) {
    Node* newNode = (Node*)malloc(sizeof(Node));
    newNode->data = value;
    newNode->next = NULL;

    if (q->rear == NULL) { // Wenn die Queue leer ist
        q->front = q->rear = newNode;
        return;
    }

    q->rear->next = newNode;
    q->rear = newNode;
}

// Funktion, um ein Element aus der Queue zu entfernen
int dequeue(Queue* q) {
    if (q->front == NULL) { // Wenn die Queue leer ist
        printf("Queue ist leer!\n");
        return -1;
    }

    Node* temp = q->front;
    int value = temp->data;
    q->front = q->front->next;

    if (q->front == NULL) { // Wenn die Queue leer wird
        q->rear = NULL;
    }

    free(temp);
    return value;
}

// Funktion, um das erste Element der Queue zu sehen
int peek(Queue* q) {
    if (q->front == NULL) {
        printf("Queue ist leer!\n");
        return -1;
    }
    return q->front->data;
}

// Funktion, um die Queue anzuzeigen
void displayQueue(Queue* q) {
    Node* current = q->front;
    if (current == NULL) {
        printf("Queue ist leer!\n");
        return;
    }

    printf("Queue: ");
    while (current != NULL) {
        printf("%d ", current->data);
        current = current->next;
    }
    printf("\n");
}

// Hauptprogramm
int main() {
    Queue* q = createQueue();

    enqueue(q, 10);
    enqueue(q, 20);
    enqueue(q, 30);

    displayQueue(q);

    printf("Entfernt: %d\n", dequeue(q));
    printf("Entfernt: %d\n", dequeue(q));

    displayQueue(q);

    enqueue(q, 40);
    displayQueue(q);

    printf("Erstes Element: %d\n", peek(q));

    return 0;
}

