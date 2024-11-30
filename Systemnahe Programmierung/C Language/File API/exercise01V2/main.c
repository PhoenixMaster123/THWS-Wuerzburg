#include <stdio.h>

int main() {
    char data[20];
    FILE *file;
    int i = 0;
    char c;

    file = fopen("example01.txt", "r");

    if (file == NULL) {
        printf("File not found\n");
        return 1;
    }

    while ( (i + 1) < 20 && (c = fgetc(file)) != EOF) { // + 1 -> comes from the terminal null symbol
        data[i++] = c;
    }
    data[i] = '\0';
    printf("%s\n", data);
    fclose(file);
    return 0;
}
