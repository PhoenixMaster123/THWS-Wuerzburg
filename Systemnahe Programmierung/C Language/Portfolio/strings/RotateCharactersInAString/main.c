#include <stdio.h>
#include <stdlib.h>
#include <string.h>

void rotate(char str[], char result[], int rotate_times) {
    int length = strlen(str);

    // Remove newline character if fgets is used
    if (str[length - 1] == '\n') {
        str[length - 1] = '\0';
        length--;  // Adjust the length after removing '\n'
    }

    // Perform rotation (right rotation)
    for (int i = 0; i < length; ++i) {
        result[(i + rotate_times) % length] = str[i];  // Use modulo to handle rotations greater than length
    }

    result[length] = '\0';  // Null-terminate the rotated string
}


int main() {
    char str[255];
    printf("Enter a string: ");
    fgets(str, 255, stdin);
    int rotateTimes;
    scanf("%d", &rotateTimes);
    char output[255];

    rotate(str, output, rotateTimes);
    printf("%s", output);

}
