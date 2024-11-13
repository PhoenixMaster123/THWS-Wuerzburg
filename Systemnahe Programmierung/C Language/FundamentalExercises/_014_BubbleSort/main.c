#include <stdio.h>
#include <stdlib.h>

// Variant 1:
int compare(const void* a, const void* b) {
    return (*(int*)a - *(int*)b);
}

// Variant 2:
void bubbleSort(int arr[], int length) {
    int i, j;
    for (i = 0; i < length - 1; i++) {
        for (j = 0; j < length - i - 1; j++) {
            if (arr[j] > arr[j + 1]) {
                int temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }
        }
    }
}

int main(void) {

    int arr[10] = {1, 3, 2, 4, 6, 5, 7, 3, 4, 10};

    int length = sizeof(arr) / sizeof(arr[0]);

    printf("The start array is: \n");
    for (int i = 0; i < length; i++) {
        printf("%d ", arr[i]);
    }

    printf("\n");
    // Variant 1:
    //qsort(arr, length, sizeof(int), compare);

    // Variant 2:
    bubbleSort(arr, length);

    printf("The sorted array is: \n");

    for (int i = 0; i < length; i++) {
        printf("%d ", arr[i]);
    }

    return 0;
}
