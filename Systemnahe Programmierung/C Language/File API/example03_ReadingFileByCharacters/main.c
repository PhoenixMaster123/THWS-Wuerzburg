#include <stdio.h>
#include <stdlib.h>

int main() {
    FILE *file;
    int c;
    file = fopen("test.txt", "r");

    while( (c = fgetc(file)) != EOF ) {
        putchar(c); // output to the console
    }
    return EXIT_SUCCESS;
}
