#include <stdio.h>

int main() {
    FILE *fileInput = fopen("fileInput.txt", "r");
    FILE *fileOutput = fopen("fileOutput.txt", "w");

    if (fileInput == NULL || fileOutput == NULL) {
        printf("Error opening file\n");
        return 1;
    }
    int c;

    while( (c = fgetc(fileInput)) != EOF ) {
        fputc(c, fileOutput);
    }
    fclose(fileInput);
    fclose(fileOutput);
    return 0;
}
