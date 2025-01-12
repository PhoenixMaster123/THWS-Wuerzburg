#include <stdio.h>


int main(void) {
    int arr[] = {1, 2, 3, 4};

    int length = sizeof(arr) / sizeof(arr[0]);

    int arrReversed[length + 1];

    int counter = 0;
    for (int i = length - 1; i >= 0; i--) {
        arrReversed[counter] = arr[i];
        counter++;
    }
    arrReversed[length + 1] = '\0';

    for (int i = 0; i < length; ++i) {
        printf("%d ", arrReversed[i]);
    }
    return 0;
}