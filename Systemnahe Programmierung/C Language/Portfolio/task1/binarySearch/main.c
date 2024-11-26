#include <stdio.h>

int binarySearch(int arr[], int length, int search_an_element) {
    int low = 0, high = length - 1;

    while (low <= high) {
        int mid = (low + high) / 2;

        if(arr[mid] == search_an_element) return mid;
        if(arr[mid] < search_an_element) low = mid + 1;
        else high = mid - 1;
    }
    return -1;
}

int main(void) {

    int arr[] = {1, 2, 3, 4, 5, 6, 7};

    int length = sizeof(arr) / sizeof(arr[0]);

    printf("Enter the element to search: ");
    int searchAnElement;
    scanf("%d", &searchAnElement);

    int result = binarySearch(arr, length, searchAnElement);
    if (result != -1) {
        printf("Element found at index %d\n", result);
    } else {
        printf("Element not found\n");
    }

    return 0;
}
