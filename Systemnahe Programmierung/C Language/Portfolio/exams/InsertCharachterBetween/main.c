#include <stdio.h>
#include <string.h>

void insertChar(char input[], char insertChar, int length);

int main(void) {
    char input[] = {"abcdefghij"};  // Input string
    char insertElement = 'x';       // Character to insert
    int len = strlen(input);        // Calculate length of the input string

    insertChar(input, insertElement, len);

    return 0;
}

void insertChar(char input[], char insertChar, int length) {
    // Resulting array has space for the inserted characters and the null terminator
    char result[length * 2];
    int index = 0;  // Index for the result array

    // Iterate through the input string
    for (int i = 0; i < length; ++i) {
        result[index++] = input[i];  // Add the current character from input
        if (i < length - 1) {
            result[index++] = insertChar;  // Add the character to insert
        }
    }

    result[index] = '\0';  // Null-terminate the resulting string

    printf("%s\n", result);  // Print the result
}
