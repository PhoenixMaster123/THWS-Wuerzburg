#include <stdio.h>

int main(void) {

    int arr[] = {1, 3, 6, 3, 5, 2, 1};

    int length = sizeof(arr) / sizeof(arr[0]);

    int max = arr[0], min = arr[0];
    for (int i = 1; i < length; i++) {
        if (arr[i] > max) max = arr[i];
        if (arr[i] < min) min = arr[i];
    }
    printf("The max number is: %d\n", max);
    printf("The min number is: %d\n", min);

    return 0;
}
