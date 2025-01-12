#include <stdio.h>
#include <string.h>

// Function to shift characters by a given number of positions
void shiftCharacters(char str[], int shift) {
    int length = strlen(str);
    for (int i = 0; i < length; ++i) {
        if (str[i] >= 'a' && str[i] <= 'z') {
            str[i] = (str[i] - 'a' + shift) % 26 + 'a';  // For lowercase letters
        } else if (str[i] >= 'A' && str[i] <= 'Z') {
            str[i] = (str[i] - 'A' + shift) % 26 + 'A';  // For uppercase letters
        }
    }
    printf("Shifted String: %s\n", str);
}

int main() {
    char str[255];
    int shift;

    printf("Enter a string: ");
    fgets(str, 255, stdin);
    str[strlen(str) - 1] = '\0';  // Remove newline character

    printf("Enter number of positions to shift: ");
    scanf("%d", &shift);

    shiftCharacters(str, shift);  // Call the function to shift the characters
    return 0;
}
