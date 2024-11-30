#include <stdio.h>
#include <stdlib.h>

int main(void) {
    FILE *file;
    char arr[20];
    char c;

    file = fopen("example01.txt", "r");
    if (file == NULL) {
        perror("Error opening file");
        return EXIT_FAILURE;
    }

    int count = 0;
    while ((c = fgetc(file)) != EOF && count < sizeof(arr) - 1) {
        if (c == '\n') {
            arr[count] = '\0';
            break;
        }
        arr[count++] = c;
    }
    arr[count] = '\0';

    fclose(file);

    printf("%s\n", arr);
    return EXIT_SUCCESS;
}


// Note: However, your loop does not check whether the count exceeds the size of the array.
// If the file content is longer than 19 characters without a newline,
// your program writes beyond the array's bounds.


/*int main(void) {
    FILE *file;
    char arr[20];
    char c;
    file = fopen("example01.txt", "r");
    int count = 0;
    while ((c = fgetc(file)) != EOF) {
        if (c == '\n') {
            arr[count] = '\0';
            break;
        }
        arr[count] = c;
        count++;
    }
    arr[count] = '\0';
    fclose(file);
    printf("%s", arr);
    return EXIT_SUCCESS;
}
*/