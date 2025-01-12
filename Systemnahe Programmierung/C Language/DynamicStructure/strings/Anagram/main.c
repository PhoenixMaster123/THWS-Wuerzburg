#include <stdio.h>
#include <string.h>
#include <ctype.h>

// Function to check if two strings are anagrams
int areAnagrams(char str1[], char str2[]) {
    int freq[256] = {0};  // Array to store character frequencies

    // If the lengths of both strings are different, they can't be anagrams
    if (strlen(str1) != strlen(str2)) {
        return 0;
    }

    // Count frequency of characters in the first string
    for (int i = 0; str1[i] != '\0'; ++i) {
        freq[tolower(str1[i])]++;  // Convert to lowercase to ignore case
        freq[tolower(str2[i])]--;  // Decrease the count for the second string
    }

    // If all frequencies are zero, the strings are anagrams
    for (int i = 0; i < 256; ++i) {
        if (freq[i] != 0) {
            return 0;
        }
    }

    return 1;
}

int main() {
    char str1[255], str2[255];

    printf("Enter the first string: ");
    fgets(str1, 255, stdin);
    str1[strlen(str1) - 1] = '\0';  // Remove newline character

    printf("Enter the second string: ");
    fgets(str2, 255, stdin);
    str2[strlen(str2) - 1] = '\0';  // Remove newline character

    if (areAnagrams(str1, str2)) {
        printf("The strings are anagrams.\n");
    } else {
        printf("The strings are not anagrams.\n");
    }

    return 0;
}
