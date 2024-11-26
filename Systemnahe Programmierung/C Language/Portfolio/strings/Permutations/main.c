#include <stdio.h>
#include <string.h>

// Helper function to swap characters
void swap(char* a, char* b) {
    char temp = *a;
    *a = *b;
    *b = temp;
}

// Function to print all permutations of a string
void permute(char str[], int l, int r) {
    if (l == r) {
        printf("%s\n", str);
    } else {
        for (int i = l; i <= r; i++) {
            swap(&str[l], &str[i]);  // Swap characters
            permute(str, l + 1, r);  // Recursive call
            swap(&str[l], &str[i]);  // Backtrack to restore the original string
        }
    }
}

int main() {
    char str[255];

    printf("Enter a string: ");
    fgets(str, 255, stdin);
    str[strlen(str) - 1] = '\0';  // Remove newline character

    int length = strlen(str);
    printf("All permutations of the string:\n");
    permute(str, 0, length - 1);

    return 0;
}
