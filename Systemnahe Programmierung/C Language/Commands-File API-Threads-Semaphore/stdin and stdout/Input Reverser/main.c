#include <stdio.h>
#include <string.h>

int main() {
    char input[255];
    fgets(input, 255, stdin);

    size_t len = strlen(input);
    char result[len];

    int counter = 0;
    for (int i = len - 1; i >= 0; --i) {
        result[counter++] = input[i];
    }
    result[counter] = '\0';
    printf("%s", result);
}
