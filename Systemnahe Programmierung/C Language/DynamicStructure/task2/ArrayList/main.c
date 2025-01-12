#include <stdbool.h>
#include <stdio.h>
#include <stdlib.h>
#define INITIAL_CAPACITY 4

typedef struct {
    int *data;      // Pointer to the dynamic array
    int size;       // Current number of elements
    int capacity;   // Maximum number of elements the array can hold
} ArrayList;

ArrayList *createArrayList(int initialCapacity);

void add(ArrayList *list, int element);
int get(ArrayList *list, int index);
int removeElement(ArrayList *list, int index);
bool contains(ArrayList *list, int element);
void grow(ArrayList *list);
void shrink(ArrayList *list);
void sort(ArrayList *list);
void print(ArrayList *list);


int main(void) {
    ArrayList *list = createArrayList(4);

    // Add elements to the ArrayList
    add(list, 10);
    add(list, 20);
    add(list, 30);
    add(list, 40);
    add(list, 50);
    add(list, 15);

    printf("%d\n", get(list, 2));
    sort(list);
    print(list);
}

ArrayList *createArrayList(int initialCapacity) {
    ArrayList *list = (ArrayList *)malloc(sizeof(ArrayList));
    if (list == NULL) {
        printf("Memory allocation error\n");
        exit(EXIT_FAILURE);
    }

    list->data = (int *)malloc(initialCapacity * sizeof(int));
    if (list->data == NULL) {
        printf("Memory allocation error\n");
        free(list);
        exit(EXIT_FAILURE);
    }

    list->size = 0;
    list->capacity = initialCapacity;
    return list;
}

void add(ArrayList *list, int element) {
    if (list->size == list->capacity) {
        grow(list);
    }
    list->data[list->size] = element;
    list->size++;
    printf("Element %d added successfully\n", element);

}
void grow(ArrayList *list) {
    int newCapacity = list->capacity * 2;
    int *newData = (int *)malloc(newCapacity * sizeof(int));
    for (int i = 0; i < list->size; i++) {
        newData[i] = list->data[i];
    }
    free(list->data);
    // Update the list to use the new array and capacity
    list->data = newData;
    list->capacity = newCapacity;

    printf("ArrayList grown to new capacity: %d\n", newCapacity);
}
int get(ArrayList *list, int index) {
    if (index < 0 || index >= list->size) {
        printf("Index is out of bounds\n");
        return -1;
    }
    for (int i = 0; i < list->size; i++) {
        if(i == index) {
            return list->data[i];
        }
    }
}


int removeElement(ArrayList *list, int index) {
    if (index < 0 || index >= list->size) {
        printf("Index is out of bounds\n");
        return -1;
    }

    int removedElement = list->data[index];

    // Shift elements to the left
    for (int i = index; i < list->size - 1; i++) {
        list->data[i] = list->data[i + 1];
    }

    list->size--;

    // Shrink the array if necessary
    if (list->size <= list->capacity / 2 && list->capacity > INITIAL_CAPACITY) {
        shrink(list);
    }

    printf("Element %d removed successfully\n", removedElement);
    return removedElement;
}

void shrink(ArrayList *list) {
    int newCapacity = list->capacity / 2;
    int *newData = (int *)malloc(newCapacity * sizeof(int));
    for (int i = 0; i < list->size; i++) {
        newData[i] = list->data[i];
    }
    free(list->data);
    list->data = newData;
    list->capacity = newCapacity;

    printf("ArrayList shrunk to new capacity: %d\n", newCapacity);
}

bool contains(ArrayList *list, int element) {
    for (int i = 0; i < list->size; i++) {
        if (list->data[i] == element) {
            return true;
        }
    }
    return false;
}

void sort(ArrayList *list) {
    for (int i = 0; i < list->size; i++) {
        for (int j = 0; j < list->size; j++) {
            if (list->data[i] < list->data[j]) {
                int temp = list->data[i];
                list->data[i] = list->data[j];
                list->data[j] = temp;
            }
        }
    }
}

void print(ArrayList *list) {
    for (int i = 0; i < list->size; i++) {
        printf("%d ", list->data[i]);
    }
    printf("\n");
}

