
#include <stdio.h>

int main() {
    FILE *file = fopen("lines.txt", "r");
    if (file == NULL) {
        printf("Error opening file");
        return 1;
    }
    char line[255];
    int lines = 0;
    while(fgets(line, sizeof(line), file) != NULL) {
        lines++;
    }
    fclose(file);
    printf("Number of lines: %d\n", lines);
    return 0;
}
