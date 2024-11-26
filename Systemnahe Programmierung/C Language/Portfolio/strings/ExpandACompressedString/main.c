#include <ctype.h>
#include <stdio.h>
#include <string.h>

void expand(char str[], int length, char result[]) {

    int index = 0;
    for (int i = 0; i < length; i++) {
        if(i + 1 == length) {
            break;
        }
        int num = str[i + 1] - '0';
        for (int j = 0; j < num; j++) {
            result[index++] = str[i];
        }
        i++;
    }
    result[index] = '\0';
}
// Option 2:

void expandString(char input[], char result[]) {
    int index = 0;
    for (int i = 0; input[i] != '\0'; ++i) {
        if (isalpha(input[i])) { // checks whether a character is an alphabet (a to z and A to Z)
            result[index++] = input[i];
        } else {
            int count = input[i] - '0';
            while (count-- > 1) {
                result[index++] = input[i - 1];
            }
        }
    }
    result[index] = '\0';
}

int main(void) {
    char inputString[] = {"a3b4c2"};
    char outputString[255];

    int length = strlen(inputString);

    expand(inputString, length, outputString);
    printf("%s", outputString);
}
