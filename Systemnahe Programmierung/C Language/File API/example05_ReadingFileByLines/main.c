
#include <stdio.h>
#include <stdlib.h>

int main() {
    FILE *file;
    const char input[80]; // max per line
    file = fopen("test.txt", "r");

    while(fgets(input, 80, file)) {
        fputs(input, stdout);
    }
    fclose(file);
    return EXIT_SUCCESS;
}
