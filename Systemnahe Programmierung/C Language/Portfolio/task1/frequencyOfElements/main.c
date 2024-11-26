#include <stdbool.h>
#include <stdio.h>

bool exists(int curr, int arr[], int length) {
    for (int i = 0; i < length; ++i) {
        if(curr == arr[i]) {
            return true;
        }
    }
    return false;
}

int findFrequency(int current_element, int arr[], int length) {
    int sum = 0;

    for (int i = 0; i < length; ++i) {
        if(current_element == arr[i]) {
            sum++;
        }
    }
    return sum;
}

int main(void) {
    int arr[] = {1, 2, 2, 3, 1, 4};

    int length = sizeof(arr) / sizeof(arr[0]);

    int arrElements[length];

    int counter = 0;

    for (int i = 0; i < length; ++i) {

        int currentElement = arr[i];

        if(!exists(currentElement, arrElements, length)) {
            int frequency = findFrequency(currentElement, arr, length);
            printf("Number %d appeared %d times.\n", currentElement, frequency);
            arrElements[counter] = currentElement;
            counter++;
        }
    }
    return 0;
}
