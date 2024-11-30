#include <stdio.h>
#include <stdlib.h>

int main(void) {
    FILE *file;
    file = fopen("text.txt", "r");

    if (file == NULL) {
        printf("File cannot be opened");
        return EXIT_FAILURE;
    }

    return EXIT_SUCCESS;
}
