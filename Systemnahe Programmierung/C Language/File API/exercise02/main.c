#include <stdio.h>

typedef struct person {
    char firstName[255];
    char lastName[255];
} Person;

int main() {
    Person person[2];
    Person bond = {"James", "Bond"};
    Person blofeld = {"Ernst", "Blofeld"};

    person[0] = bond;
    person[1] = blofeld;

    FILE *file = fopen("persons.csv", "w");

    if (file == NULL) {
        printf("File could not be opened\n");
        return 1;
    }
    for(int i = 0; i < 2; i++) {
        fprintf(file, "%s;%s\n", person[i].firstName, person[i].lastName);
    }
    fclose(file);
    return 0;
}
