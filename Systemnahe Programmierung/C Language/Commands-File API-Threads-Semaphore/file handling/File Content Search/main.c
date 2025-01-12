#include <stdio.h>
#include <string.h>


int main() {
    char line[256];
    char searchString[255];  // Adjusted to allow user input

    // Prompt user to input the search string
    printf("Enter the string to search for: ");
    fgets(searchString, sizeof(searchString), stdin);

    // Remove newline character if present
    searchString[strcspn(searchString, "\n")] = '\0';

    int found = 0;

    // Open the file in read mode
    FILE *file = fopen("fileInput.txt", "r");
    if (file == NULL) {
        perror("Error opening file");
        return 1;
    }

    // Read the file line by line
    while (fgets(line, sizeof(line), file) != NULL) {
        // Check if the line contains the search string
        if (strstr(line, searchString) != NULL) {
            printf("Found: %s", line);
            found = 1;
        }
    }

    if (!found) {
        printf("The string '%s' was not found in the file.\n", searchString);
    }

    // Close the file
    fclose(file);
    return 0;
}