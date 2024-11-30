
#include <stdio.h>
#include <stdlib.h>

int main() {
    FILE *file;
    const char* output = "Hello World!";
    int c;

    file = fopen("test.txt", "w+");

    while((c = *output++) != 0) {
        fputc(c, file);
    }
    return EXIT_SUCCESS;

    // Note: cmake-build-debug is your created file
}
