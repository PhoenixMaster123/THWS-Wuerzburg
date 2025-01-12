#include <stdio.h>

int main() {
    int arr[10];

    printf("Enter 10 numbers:\n");
    for (int i = 0; i < 10; i++) {
        scanf("%d", &arr[i]); // Ensure proper input handling
    }

    printf("Array before sorting:\n");
    for (int i = 0; i < 10; i++) {
        printf("%d ", arr[i]);
    }
    printf("\n");

    // Bubble sort
    for (int i = 0; i < 10 - 1; i++) {
        for (int j = 0; j < 10 - i - 1; j++) {
            if (arr[j] > arr[j + 1]) {
                int temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }
        }
    }

    printf("Array after sorting:\n");
    for (int i = 0; i < 10; i++) {
        printf("%d ", arr[i]); // Print numbers with a single space
    }
    printf("\n");

    return 0;
}
