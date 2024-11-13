#include <stdio.h>

void checkNumber(int number, int arr[], int length) {

    for (int i = 0; i < length; i++) {
        if (arr[i] == number) {
            printf("The number: %d is in this array \n", arr[i]);
            return;
        }
    }
    printf("The number: %d is not in this array \n", number);
}

int main(void) {
    int number;
    int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    printf("Enter a number: ");
    scanf("%d", &number);

    int length = sizeof(arr) / sizeof(arr[0]);

    checkNumber(number, arr, length);

    return 0;
}
