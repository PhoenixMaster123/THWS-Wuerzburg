#include <stdio.h>

int main(void) {
    int a = 10, b = 20;
    int *arr[10]; // Array of 10 int pointers
    arr[0] = &a;  // Assign address of a
    arr[1] = &b;  // Assign address of b

    printf("%d %d\n", *arr[0], *arr[1]); // Outputs: 10 20

    int myArray[10] = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    int (*arr2)[10] = &myArray; // arr points to myArray

    printf("%d\n", (*arr2)[0]); // Access first element of myArray, Outputs: 0
    printf("%d\n", (*arr2)[1]); // Access second element of myArray, Outputs: 1

    // Note:
    // Use int *arr[10] when you need an array of pointers to int.
    // Use int (*arr)[10] when you need a pointer to an array of 10 ints.
}
