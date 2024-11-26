#include <stdio.h>
#include <string.h>

void compress(char string_input[], int length, char result[]) {
    int index = 0;
    for (int i = 0; i < length; i++) {
       char curr = string_input[i];
       result[index++] = curr;
        int sum = 0;
        for(int j = i; j < length; j++) {
            if(string_input[j] == curr) {
                sum++;
            } else {
                break;
            }
        }
        result[index++] = sum + '0';
        i += sum - 1;
    }
    result[index] = '\0';
}
// Variant 2:
void compress2(const char string_input[], int length, char result[]) {
    int index = 0; // Index for result array

    for (int i = 0; i < length; i++) {
        char curr = string_input[i];
        result[index++] = curr; // Add the current character to result

        int count = 0; // Count occurrences of the current character
        while (i < length && string_input[i] == curr) {
            count++;
            i++;
        }
        i--; // Adjust `i` because it is incremented one extra time in the loop

        // Convert count to a string and add it to the result
        int digits = snprintf(&result[index], 10, "%d", count); // Handles multi-digit counts
        index += digits;
    }

    result[index] = '\0'; // Null-terminate the result
}


int main(void) {
    char stringInput[] = {"aaabbbbcc"};
    char stringOutput[255];
    int stringLength = strlen(stringInput);

    compress(stringInput, stringLength, stringOutput);
    printf("%s", stringOutput);

    return 0;
}
