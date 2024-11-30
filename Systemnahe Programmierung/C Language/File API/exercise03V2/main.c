#include <stdio.h>
#include <string.h>

struct person {
    char firstName[255];
    char lastName[255];
};

int main(void) {
    struct person data[20];
    FILE *file = fopen("persons.csv", "r");

    if (file == NULL) {
        printf("Error opening file\n");
        return 1;
    }
    char buffer[80];
    int i = 0;
    struct person somePerson;

    while (fgets(buffer, 80, file)) {
        char *token = strchr(buffer, ';');
        strncpy(somePerson.firstName, buffer, (token-buffer));
        strcpy(somePerson.lastName, token + 1);
        data[i++] = somePerson;
    }
    for(int j = 0; j <= i; j++) {
        printf("%s %s", data[j].firstName, data[j].lastName);
    }
    fclose(file);
    return 0;
}