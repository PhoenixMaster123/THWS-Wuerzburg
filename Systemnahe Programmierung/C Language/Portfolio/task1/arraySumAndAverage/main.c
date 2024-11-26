#include <stdio.h>

int findSum(int arr[], int length) {
    int sum = 0;

    for (int i = 0; i < length; ++i) {
        sum += arr[i];
    }
    return sum;
}
double findAverage(int arr[], int length) {
    double average = 0;

    for (int i = 0; i < length; ++i) {
        average += arr[i];
    }
    return average / length;
}

int main(void) {
    int arr[10];

    for (int i = 0; i < 10; ++i) {
        scanf("%d", &arr[i]);
    }
    int length = sizeof(arr) / sizeof(arr[0]);

    int sum = findSum(arr, length);
    double average = findAverage(arr, length);

    printf("The sum is: %d\n", sum);
    printf("The average is: %.2f\n", average);

    return 0;
}
