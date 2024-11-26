#include <stdio.h>

int main(void) {
    int matrix1[3][3] = {{1, 2, 3}, {3,4,5}, {6,7,8} };
    int matrix2[3][3] = {{7,8,9}, {1,2,3}, {10, 12, 13}};
    int result[3][3];

    int rows = sizeof(matrix1) / sizeof(matrix1[0]);       // Number of rows
    int cols = sizeof(matrix1[0]) / sizeof(matrix1[0][0]); // Number of columns

    for (int row = 0; row < rows; ++row) {
        for (int col = 0; col < cols; ++col) {
            result[row][col] = matrix1[row][col] + matrix2[row][col];
        }
    }
    for (int row = 0; row < rows; ++row) {
        for (int col = 0; col < cols; ++col) {
            printf("%d ", result[row][col]);
        }
        printf("\n");
    }


    return 0;
}