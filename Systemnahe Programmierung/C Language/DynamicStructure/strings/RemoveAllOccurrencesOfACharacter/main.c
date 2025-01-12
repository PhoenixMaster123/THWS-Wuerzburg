#include <stdio.h>
#include <string.h>

void removeOccurrences(char str[], char remove_char, char result[]) {
    int len = strlen(str);

    int index = 0;
    for (int i = 0; i < len; ++i) {
        if(str[i] != remove_char) {
            result[index] = str[i];
            index++;
        }
    }
    result[index] = '\0';
}

int main(void) {
    char input[255];
    fgets(input, 255, stdin);
    char removeChar;
    scanf("%c", &removeChar);
    char result[255];

    removeOccurrences(input, removeChar, result);
    printf("%s", result);

    return 0;
}
