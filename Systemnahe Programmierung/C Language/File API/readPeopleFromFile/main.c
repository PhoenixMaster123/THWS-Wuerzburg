#include <stdio.h>
#include <string.h>

// Reading a file

typedef struct person {
    char firstName[255];
    char lastName[255];
} Person;

int main() {
    Person person[3];
    int length = sizeof(person) / sizeof(Person);
    char line[255];
    int index = 0;
    FILE *file = fopen("persons.txt", "r");

    if (file == NULL) {
        printf("File not found\n");
        return 1;
    }
    while (fgets(line, sizeof(line), file) != NULL && index < length) {
        // Remove newline character if present
        size_t len = strlen(line);
        if (len > 0 && line[len - 1] == '\n') {
            line[len - 1] = '\0';
        }

        // Tokenize the line using ";"
        char *firstName = strtok(line, ";");
        char *lastName = strtok(NULL, ";");

        if (firstName != NULL && lastName != NULL) {
            // Populate the person array
            strncpy(person[index].firstName, firstName, sizeof(person[index].firstName) - 1);
            strncpy(person[index].lastName, lastName, sizeof(person[index].lastName) - 1);

            // Null-terminate the strings to prevent buffer overflows
            person[index].firstName[sizeof(person[index].firstName) - 1] = '\0';
            person[index].lastName[sizeof(person[index].lastName) - 1] = '\0';

            index++; // Move to the next person
        } else {
            printf("Invalid line format: %s\n", line);
        }
    }

    fclose(file);

    // Print the loaded data
    for (int i = 0; i < index; i++) {
        printf("Person %d: %s %s\n", i + 1, person[i].firstName, person[i].lastName);
    }
}
