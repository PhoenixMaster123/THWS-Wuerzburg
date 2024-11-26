#include <stdio.h>
#include <stdlib.h>

// Node structure
typedef struct node {
    int element;
    struct node *next; // Pointer to the next node
    struct node *prev; // Pointer to the previous node
} Node;

// List structure
typedef struct list {
    Node *head; // Pointer to the head node
    Node *tail; // Pointer to the tail node
    int size;   // Number of elements in the list
} List;

// Function prototypes
void insertAtHead(List *list, int element);
void insertAtTail(List *list, int element);
int deleteAtHead(List *list);
int deleteAtTail(List *list);
void printList(List *list);

int main() {
    List *list = (List *)malloc(sizeof(List));
    list->head = NULL;
    list->tail = NULL;
    list->size = 0;

    // Test insertions
    insertAtHead(list, 10);
    insertAtHead(list, 20);
    insertAtTail(list, 5);
    printList(list);

    // Test deletions
    deleteAtHead(list);
    printList(list);
    deleteAtTail(list);
    printList(list);

    // Free the list
    free(list);

    return 0;
}

// Insert at the head of the list
void insertAtHead(List *list, int element) {
    Node *newNode = (Node *)malloc(sizeof(Node));
    newNode->element = element;
    newNode->prev = NULL;
    newNode->next = list->head;

    if (list->head != NULL) {
        list->head->prev = newNode;
    } else {
        list->tail = newNode; // If the list was empty, set tail to the new node
    }

    list->head = newNode;
    list->size++;
}

// Insert at the tail of the list
void insertAtTail(List *list, int element) {
    Node *newNode = (Node *)malloc(sizeof(Node));
    newNode->element = element;
    newNode->next = NULL;
    newNode->prev = list->tail;

    if (list->tail != NULL) {
        list->tail->next = newNode;
    } else {
        list->head = newNode; // If the list was empty, set head to the new node
    }

    list->tail = newNode;
    list->size++;
}

// Delete the head of the list
int deleteAtHead(List *list) {
    if (list->head == NULL) {
        printf("List is empty\n");
        return -1;
    }

    Node *temp = list->head;
    int element = temp->element;

    list->head = list->head->next;
    if (list->head != NULL) {
        list->head->prev = NULL;
    } else {
        list->tail = NULL; // List is now empty
    }

    free(temp);
    list->size--;
    return element;
}

// Delete the tail of the list
int deleteAtTail(List *list) {
    if (list->tail == NULL) {
        printf("List is empty\n");
        return -1;
    }

    Node *temp = list->tail;
    int element = temp->element;

    list->tail = list->tail->prev;
    if (list->tail != NULL) {
        list->tail->next = NULL;
    } else {
        list->head = NULL; // List is now empty
    }

    free(temp);
    list->size--;
    return element;
}

// Print the list
void printList(List *list) {
    Node *current = list->head;
    printf("List: ");
    while (current != NULL) {
        printf("%d ", current->element);
        current = current->next;
    }
    printf("\n");
}
