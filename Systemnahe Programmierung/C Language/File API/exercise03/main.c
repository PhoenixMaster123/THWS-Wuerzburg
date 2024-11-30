#include <stdio.h>
#include <string.h>

int main() {
    FILE *file = fopen("persons.csv", "r");
    if (file == NULL) {
        printf("File not found\n");
        return 1;
    }
    char line[80];
    while (fgets(line, 80, file)) {
        char *token = strtok(line, ";");
        char *firstName = token;
        token = strtok(NULL, ";");
        char *lastName = token;
        printf("%s %s", firstName, lastName);
    }
    fclose(file);
    return 0;
}
