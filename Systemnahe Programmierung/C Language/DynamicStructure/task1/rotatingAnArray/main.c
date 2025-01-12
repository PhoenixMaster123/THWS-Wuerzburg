#include <stdio.h>


// Variant 2:
void rotateArray(int arr[], int n) {
    int temp = arr[n - 1]; // Store the last element
    for (int i = n - 1; i > 0; i--) {
        arr[i] = arr[i - 1]; // Shift elements to the right
    }
    arr[0] = temp; // Place the last element at the first position
}

void rotateNTimes(int arr[], int length, int times) {
    // Ensure the number of rotations is within bounds
    times = times % length;

    // Temporary array to store the rotated result
    int temp[length];

    // Copy the rotated portion to the beginning of temp
    for (int i = 0; i < times; ++i) {
        temp[i] = arr[length - times + i];
    }

    // Copy the remaining elements
    for (int i = 0; i < length - times; ++i) {
        temp[times + i] = arr[i];
    }

    // Copy temp back to the original array
    for (int i = 0; i < length; ++i) {
        arr[i] = temp[i];
    }
}

int main(void) {

    int arr[] = {1, 2, 3, 4, 5, 6};

    int length = sizeof(arr) / sizeof(arr[0]);

    //int rotatedArr[length + 1];

    //rotateArray(arr, length);
    rotateNTimes(arr, length, 2);

    // Variant 1:
    /*for (int i = 0; i < length; ++i) {

        if(i + 1 == length) {
            rotatedArr[0] = arr[i];
        }
        rotatedArr[i + 1] = arr[i];
    }

    rotatedArr[length + 1] = '\0';
    */

    for (int i = 0; i < length; ++i) {
        printf("%d ", arr[i]);
    }

    return 0;
}