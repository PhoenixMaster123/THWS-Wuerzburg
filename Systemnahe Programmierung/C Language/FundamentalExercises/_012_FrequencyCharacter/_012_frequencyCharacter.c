#include <ctype.h>
#include <stdbool.h>
#include <stdio.h>
#include <string.h>

bool checker(char c) {
    static char storage[52];
    static int position = 0;

    for (int i = 0; i < position; i++) {
        if (storage[i] == tolower(c)) {
            return false;
        }
    }
    storage[position++] = tolower(c);
    return true;
}

int countOccurrence(char c, char input[]) {
    int count = 0;
    for (int i = 0; i < strlen(input); i++) {
        if(input[i] == tolower(c) || input[i] == toupper(c)) {
            count++;
        }
    }
    return count;
}

int main(void) {
    char input[52];
    printf("Enter a string: ");
    fgets(input, 52, stdin);

    input[strlen(input) - 1] = '\0';

    int len = strlen(input);

    for (int i = 0; i < len; i++) {
        char currentChar = input[i];
        if(checker(currentChar)) {
            int count = countOccurrence(currentChar, input);
            printf("The char %c occurred %d\n", currentChar, count);
        }
    }

}

