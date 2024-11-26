#include <stdio.h>
#include <stdlib.h>

// Node structure
typedef struct node {
    int element;
    struct node *next; // Pointer to the next node
    struct node *prev; // Pointer to the previous node
} Node;

// Function prototypes
void insertAtHead(Node **head, Node **tail, int element);
void insertAtTail(Node **head, Node **tail, int element);
int deleteAtHead(Node **head, Node **tail);
int deleteAtTail(Node **head, Node **tail);
void printList(Node *head);

int main() {
    Node *head = NULL; // Pointer to the head of the list
    Node *tail = NULL; // Pointer to the tail of the list

    // Test insertions
    insertAtHead(&head, &tail, 10);
    insertAtHead(&head, &tail, 20);
    insertAtTail(&head, &tail, 5);
    printList(head);

    // Test deletions
    deleteAtHead(&head, &tail);
    printList(head);
    deleteAtTail(&head, &tail);
    printList(head);

    return 0;
}

// Insert at the head of the list
void insertAtHead(Node **head, Node **tail, int element) {
    Node *newNode = (Node *)malloc(sizeof(Node));
    newNode->element = element;
    newNode->prev = NULL;
    newNode->next = *head;

    if (*head != NULL) {
        (*head)->prev = newNode;
    } else {
        *tail = newNode; // If the list was empty, set tail to the new node
    }

    *head = newNode;
}

// Insert at the tail of the list
void insertAtTail(Node **head, Node **tail, int element) {
    Node *newNode = (Node *)malloc(sizeof(Node));
    newNode->element = element;
    newNode->next = NULL;
    newNode->prev = *tail;

    if (*tail != NULL) {
        (*tail)->next = newNode;
    } else {
        *head = newNode; // If the list was empty, set head to the new node
    }

    *tail = newNode;
}

// Delete the head of the list
int deleteAtHead(Node **head, Node **tail) {
    if (*head == NULL) {
        printf("List is empty\n");
        return -1;
    }

    Node *temp = *head;
    int element = temp->element;

    *head = (*head)->next;
    if (*head != NULL) {
        (*head)->prev = NULL;
    } else {
        *tail = NULL; // List is now empty
    }

    free(temp);
    return element;
}

// Delete the tail of the list
int deleteAtTail(Node **head, Node **tail) {
    if (*tail == NULL) {
        printf("List is empty\n");
        return -1;
    }

    Node *temp = *tail;
    int element = temp->element;

    *tail = (*tail)->prev;
    if (*tail != NULL) {
        (*tail)->next = NULL;
    } else {
        *head = NULL; // List is now empty
    }

    free(temp);
    return element;
}

// Print the list
void printList(Node *head) {
    Node *current = head;
    printf("List: ");
    while (current != NULL) {
        printf("%d ", current->element);
        current = current->next;
    }
    printf("\n");
}
