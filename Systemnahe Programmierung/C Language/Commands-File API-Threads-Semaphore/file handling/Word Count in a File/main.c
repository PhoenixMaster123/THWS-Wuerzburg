#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main(void) {
    FILE *input = fopen("fileInput.txt", "r");
    const char delimiters[] = " ,;.!?\n";
    if (input == NULL) {
        printf("Error opening file\n");
        return 1;
    }
    int wordCount = 0;
    char line[255];
    while(fgets(line, sizeof(line), input) != NULL) {
        char *tokens = strtok(line, delimiters);
        while (tokens != NULL) {
            wordCount++;              // Increment word count for each token
            tokens = strtok(NULL, delimiters); // Get the next token
        }
    }
    fclose(input);
    printf("Number of words: %d\n", wordCount);
    return EXIT_SUCCESS;
}
