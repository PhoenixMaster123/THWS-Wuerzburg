#include <stdio.h>
#include <string.h>

void reverseString(char str[], int length, char result[]) {
    for (int i = 0; i < length; ++i) {
        result[i] = str[length - 1 - i];
    }
    result[length] = '\0';
}

int main(void) {
    char inputString[255];

    fgets(inputString, 255, stdin);

    char result[255];

    int length = strlen(inputString);

    reverseString(inputString, length, result);
    printf("%s", result);

}
