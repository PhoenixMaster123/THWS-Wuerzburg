#include <stdio.h>
#include <stdlib.h>

typedef struct element {
    int value;
    struct element *next;
} Element;



void printList(Element *head);
void insertAtHead(Element **head, int value);
void insertAtTail(Element **head, int value);
void insertAtPosition(Element **head, int position, int value);
void deleteHead(Element **head);
void deleteAtTail(Element **head);


int main(void) {
    Element *head = NULL;

    insertAtHead(&head, 6);
    insertAtHead(&head, 5);
    insertAtHead(&head, 4);
    insertAtHead(&head, 2);
    insertAtHead(&head, 1);
    printList(head);
    printf("\n");

    insertAtPosition(&head, 2, 3); //todo fix
    printList(head);
    printf("\n");

    return 0;
}

void insertAtHead(Element **head, int value) {
    Element *newElement = NULL;
    newElement = (Element *) malloc(sizeof(Element));
    if(newElement == NULL) {
        printf("Memory allocation error");
        return;
    }
    newElement->value = value;
    newElement->next = *head;
    *head = newElement;
    printf("inserted %d at Head\n", newElement->value);
}

void insertAtTail(Element **head, int value) {
    // Allocate memory for the new node
    Element *newElement = malloc(sizeof(Element));
    // Check if the memory is successfully allocated
    if(newElement == NULL) {
        printf("Memory allocation error");
        return;
    }
    // Initialized new Node
    newElement->value = value;
    Element *current = *head;

    // If the list is empty, make the new node the head
    if(current == NULL) {
        *head = newElement;
        return;
    }
    // Traverse to the end of the list
    while(current->next != NULL) {
        current = current->next;
    }
    // Link the new node at the tail
    current->next = newElement;
    printf("inserted %d at Tail\n", newElement->value);
}

void insertAtPosition(Element **head, int position, int value) {
    Element *newNode = NULL;
    newNode = (Element *) malloc(sizeof(Element));

    if(newNode == NULL) {
        printf("Memory allocation error");
        return;
    }
    newNode->value = value;
    newNode->next = *head;

    if(*head == NULL) {
        *head = newNode;
        return;
    }
    Element *current = *head;
    int counter = 0;
    while(current->next != NULL && counter < position - 1) {
        current = current->next;
        newNode->next = current->next;
        counter++;
    }
}

void deleteAtHead(Element **head) {
    if(*head == NULL) {
        printf("The list is empty");
    }
    Element *curr = (*head)->next;
    free(*head);
    *head = curr;
    printf("deleted %d at head\n", curr->value);
}

void deleteAtTail(Element **head) {
    if(*head == NULL) {
        printf("The list is empty");
    }
    Element *curr = *head;
    Element *prev = NULL;
    while (curr != NULL && curr->next != NULL) {
        prev = curr;
        curr = curr->next;
    }
    if (prev == NULL) {//when only one element is there
        free(curr);
        *head = NULL;
    }
    prev->next = NULL;          //delete the pointer to the tail element
    int debugval = curr->value;
    free(curr);                 //free the space of the detached tail
    printf("deleted %d at tail\n", debugval);

}


void printList(Element *head) {
    while(head != NULL) {
        printf("%d\n", head->value);
        head = head->next;
    }
}
