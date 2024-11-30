#include <stdio.h>
#include <stdlib.h>

int main() {
    FILE *file;
    const char *output = "HELLO World";

    file = fopen("test.txt", "w+");

    fputs(output, file);
    fclose(file);

    return EXIT_SUCCESS;
}
